package com.medicalsystem.Medical.service.Implservices;

import com.medicalsystem.Medical.service.Response;
import com.medicalsystem.Medical.service.dao.IDiagnosesResultRepository;
import com.medicalsystem.Medical.service.entity.*;
import com.medicalsystem.Medical.service.restcontroller.BaseController;
import com.medicalsystem.Medical.service.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
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
    private IDiseaseService diseaseService;

    @Autowired
    private IDonationRequestService donationRequestService;


    @Override
    public Response<DiagnosesResult> addDiagnosesResult(DiagnosesResult diagnosesResult) {
        diagnosesResult.setUserId(getCurrentUser().getId());
        var diagnosisRequest = diagnosesRequestService.getDiagnosesRequestById(diagnosesResult.getDiagnosisRequestId()).getData();
        var symptoms = diagnosisRequest.getSymptoms();
        try {
            var disease = predict(symptoms);
            diagnosesResult.setDiseaseId(disease.getId());
        } catch (InterruptedException | IOException e) {
            System.out.println("Error in predict function");
        }
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

    private Disease predict(List<String> symptoms) throws InterruptedException, IOException {
        var symptomsEncodedString = new StringBuilder();
        getSymptoms().forEach(x -> {
            if (symptoms.contains(x)) symptomsEncodedString.append('1');
            else symptomsEncodedString.append('0');
        });
        String workingDirectory = "C:\\Users\\mohamed\\Desktop\\MedicalServicePredictionModel";
        var process = new ProcessBuilder("python", "test.py", symptomsEncodedString.toString())
                .directory(new File(workingDirectory))
                .start();
        process.waitFor();
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(workingDirectory + "/prediction.txt")));
        String diseaseName = reader.readLine();
        reader.close();

        System.out.println(diseaseName);
        var diseaseResponse = diseaseService.findDiseaseByName(diseaseName);
        if (diseaseResponse.isSuccess())
            return diseaseResponse.getData();
        else {
            process = new ProcessBuilder("python", "DiseaseManagerBSoup.py", diseaseName)
                    .directory(new File("/home/mohamed/PycharmProjects/medicineWebScrap/"))
                    .start();
            process.waitFor();
        }
        diseaseResponse = diseaseService.findDiseaseByName(diseaseName);
        return diseaseResponse.getData();
    }

    private static ArrayList<String> getSymptoms() {
        var symptoms = new ArrayList<String>();
        symptoms.add("itching");
        symptoms.add("skin_rash");
        symptoms.add("chills");
        symptoms.add("joint_pain");
        symptoms.add("vomiting");
        symptoms.add("fatigue");
        symptoms.add("weight_loss");
        symptoms.add("lethargy");
        symptoms.add("cough");
        symptoms.add("high_fever");
        symptoms.add("breathlessness");
        symptoms.add("sweating");
        symptoms.add("headache");
        symptoms.add("yellowish_skin");
        symptoms.add("dark_urine");
        symptoms.add("nausea");
        symptoms.add("loss_of_appetite");
        symptoms.add("abdominal_pain");
        symptoms.add("diarrhoea");
        symptoms.add("mild_fever");
        symptoms.add("yellowing_of_eyes");
        symptoms.add("swelled_lymph_nodes");
        symptoms.add("malaise");
        symptoms.add("blurred_and_distorted_vision");
        symptoms.add("phlegm");
        symptoms.add("chest_pain");
        symptoms.add("dizziness");
        symptoms.add("excessive_hunger");
        symptoms.add("loss_of_balance");
        symptoms.add("irritability");
        symptoms.add("muscle_pain");
        return symptoms;
    }
}
