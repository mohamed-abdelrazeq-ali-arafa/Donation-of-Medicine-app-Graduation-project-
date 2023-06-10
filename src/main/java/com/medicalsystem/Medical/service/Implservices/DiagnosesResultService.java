package com.medicalsystem.Medical.service.Implservices;

import com.medicalsystem.Medical.service.Response;
import com.medicalsystem.Medical.service.dao.IDiagnosesResultRepository;
import com.medicalsystem.Medical.service.entity.DiagnosesRequest;
import com.medicalsystem.Medical.service.entity.DiagnosesResult;
import com.medicalsystem.Medical.service.entity.DonationRequest;
import com.medicalsystem.Medical.service.entity.Transaction;
import com.medicalsystem.Medical.service.restcontroller.BaseController;
import com.medicalsystem.Medical.service.services.IDiagnosesRequestService;
import com.medicalsystem.Medical.service.services.IDiagnosesResultService;
import com.medicalsystem.Medical.service.services.IDonationRequestService;
import com.medicalsystem.Medical.service.services.ITransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiagnosesResultService extends BaseController implements IDiagnosesResultService {


    private IDiagnosesResultRepository diagnosesResultRepository;

    @Autowired
    public DiagnosesResultService(IDiagnosesResultRepository diagnosesResultRepository) {

        this.diagnosesResultRepository = diagnosesResultRepository;

    }

    @Autowired
    private ITransactionService transactionService;

    @Autowired
    private IDiagnosesRequestService diagnosesRequestService;

    @Autowired
    private IDonationRequestService donationRequestService;


    @Override
    public Response<DiagnosesResult> addDiagnosesResult(DiagnosesResult diagnosesResult) {
        diagnosesResult.setUserId(getCurrentUser().getId());
        var res = new Response<DiagnosesResult>();
        diagnosesResultRepository.save(diagnosesResult);
        res.make("Success Insert of DiagnosesResult", 201, diagnosesResult);
        return res;
    }

    @Override
    public Response<DiagnosesResult> getDiagnosesResultById(String id) {
        var res = new Response();
        DiagnosesResult tempDiagnosesResult = diagnosesResultRepository.findById(id).orElse(null);
        if (tempDiagnosesResult == null)
            res.make("Failed Retrive of DiagnosesResult with this id ", 400, null);
        else {
            res.make("Success Retrive of DiagnosesResult", 201, tempDiagnosesResult);

        }
        return res;
    }

    @Override
    public Response<List<DiagnosesResult>> getDiagnosesResultForUserId() {
        boolean result = checkIfDoctorOrNot(getCurrentUser());
        var res = new Response();
        if (result) {
            List<DiagnosesResult> diagnosesRsults = diagnosesResultRepository.findAll();
            res.make("Success Retrive of all  DiagnosesResult", 200, diagnosesRsults);
        } else if (result == false) {
            List<DiagnosesResult> temp = diagnosesResultRepository.findByUserId(getCurrentUser().getId());
            if (temp == null)
                res.make("Failed Retrive of DiagnosesResult", 400, temp);
            else
                res.make("Success Retrive of DiagnosesResult", 201, temp);
        }
        return res;
    }

    @Override
    public Response<List<DiagnosesResult>> getAllDiagnosesResult() {
        var res = new Response();
        List<DiagnosesResult> diagnosesResults = diagnosesResultRepository.findAll();
        res.make("Sucess retrive of DiagnosesResult", 200, diagnosesResults);
        return res;
    }

    @Override
    public Response<DiagnosesResult> deleteDiagnosesResultRequestById(String id) {
        var res = new Response();
        DiagnosesResult tempDiagnosesResults = diagnosesResultRepository.findById(id).orElse(null);
        if (tempDiagnosesResults == null)
            res.make("Failed Deletion of DiagnosesResult with this id ", 400, null);
        else {
            res.make("Success Deleteion of DiagnosesResult", 201, tempDiagnosesResults);
            diagnosesResultRepository.deleteById(id);
        }
        return res;
    }

    @Override
    public Response<DiagnosesResult> updateDiagnosesResult(String id, DiagnosesResult diagnosesResult) {
        var res = new Response();
        DiagnosesResult tempDiagnosesResults = diagnosesResultRepository.findById(id).orElse(null);
        if (tempDiagnosesResults == null)
            res.make("Failed There is No DiagnosesResult with this id", 400, null);
        else {
            String statusValue = String.valueOf((diagnosesResult.getState()));
            if (statusValue.equals("COMPLETE")) {

                for (String i : diagnosesResult.getMedicationId()) {
                    Transaction transaction = new Transaction();
                    transaction.setQuantity(11);
                    transaction.setMyStatusValue(Transaction.status.Active);
                    transaction.setMedicineId(i);
                    //get user id to save in transaction
                    Response<DiagnosesRequest> diagnosesRequest = diagnosesRequestService.getDiagnosesRequestById(diagnosesResult.getDiagnosisRequestId());
                    transaction.setReceiverId(diagnosesRequest.getData().getUserId());
                    transactionService.addTransaction(transaction);
                    computeDonationRequests(transaction.getMedicineId());
                }

            }

            tempDiagnosesResults.setDiagnoses(diagnosesResult.getDiagnoses());
            tempDiagnosesResults.setState(diagnosesResult.getState());
            tempDiagnosesResults.setDoctorId(diagnosesResult.getDoctorId());
            tempDiagnosesResults.setUpdatedAt(diagnosesResult.getUpdatedAt());
            tempDiagnosesResults.setMedicationId(diagnosesResult.getMedicationId());
            tempDiagnosesResults.setDiseaseId(diagnosesResult.getDiseaseId());

            diagnosesResultRepository.save(tempDiagnosesResults);
            res.make("Sucess Update of DiagnosesResult", 200, tempDiagnosesResults);
        }

        return res;
    }

    private void computeDonationRequests(String medicineId) {
        var transactions = transactionService.getallTransaction().getData();
        transactions = transactions.stream().filter(transaction -> transaction.getMedicineId().equals(medicineId) && transaction.getMyStatusValue().equals(Transaction.status.Active)).toList();
        var quantity = transactions.stream().mapToInt(Transaction::getQuantity).sum();
        if (quantity < 10)
            return;
        final var donationRequest = getDonationRequestByMedicineId(medicineId);
        donationRequest.setNeeded(quantity + donationRequest.getNeeded());
        transactions.forEach(x ->
                {
                    x.setDonationRequestId(donationRequest.getId());
                    x.setMyStatusValue(Transaction.status.AttachedToDonationRequest);
                }
        );
        transactions.forEach(x -> transactionService.updateTransaction(x.getId(), x));
        donationRequestService.updateDonationRequest(donationRequest.getId(), donationRequest);
    }

    private DonationRequest getDonationRequestByMedicineId(String medicineId) {
        var donationRequests = donationRequestService.getAllDonationRequest().getData();
        var donationRequest = donationRequests.stream().filter(x -> x.getMedicineId().equals(medicineId)).findFirst().orElse(null);
        if (donationRequest == null) {
            donationRequest = new DonationRequest();
            donationRequest.setMedicineId(medicineId);
            donationRequestService.addDonationRequest(donationRequest);
        }
        return donationRequest;
    }
}
