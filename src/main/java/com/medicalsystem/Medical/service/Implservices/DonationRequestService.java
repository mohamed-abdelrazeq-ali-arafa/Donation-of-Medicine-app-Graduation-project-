package com.medicalsystem.Medical.service.Implservices;


import com.medicalsystem.Medical.service.Response;
import com.medicalsystem.Medical.service.dao.IDonationRequestRepository;
import com.medicalsystem.Medical.service.entity.DonationRequest;
import com.medicalsystem.Medical.service.services.IDonationRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DonationRequestService implements IDonationRequestService {

    private IDonationRequestRepository donationRequestRepository;

    @Autowired
    public DonationRequestService(IDonationRequestRepository donationRequestRepository){
        this.donationRequestRepository=donationRequestRepository;
    }




    @Override
    public Response<DonationRequest> addDonationRequest(DonationRequest donationRequest) {
        var res= new Response<DonationRequest>();
        donationRequestRepository.save(donationRequest);
        res.make("Successful insertion for donation request",200,donationRequest);
        return res;
    }

    @Override
    public Response<DonationRequest> deleteDonationRequest(String id) {
        var res= new Response<DonationRequest>();
        DonationRequest temp= donationRequestRepository.findById(id).orElse(null);
        if(temp==null)
            res.make("There is No donation request with this id",400,null);
        else
        {
            donationRequestRepository.delete(temp);
            res.make("Successfull deletion",200,temp);

        }
        return res;
    }

    @Override
    public Response<DonationRequest> getDonationRequest(String id) {
        var res= new Response<DonationRequest>();
        DonationRequest temp= donationRequestRepository.findById(id).orElse(null);
        if(temp==null)
            res.make("There is No donation request with this id",400,null);
        else
        {
            res.make("Successfull deletion",200,temp);
        }
        return res;
    }

    @Override
    public Response<List<DonationRequest>> getAllDonationRequest() {
        var res= new Response<List<DonationRequest>>();
        List<DonationRequest> temp= donationRequestRepository.findAll();
        if(temp==null)
            res.make("There is No donation request with this id",400,null);
        else
        {
            res.make("Successfull deletion",200,temp);
        }
        return res;
    }

    @Override
    public Response<DonationRequest> updateDonationRequest(String id, DonationRequest donationRequest) {
        var res= new Response<DonationRequest>();
        DonationRequest temp= donationRequestRepository.findById(id).orElse(null);
        if(temp==null)
            res.make("There is No donation request with this id",400,null);
        else
        {
            temp.setCollected(donationRequest.getCollected());
            temp.setConteibuterCount(donationRequest.getConteibuterCount());
            temp.setNeeded(donationRequest.getNeeded());
            temp.setEndDate(donationRequest.getEndDate());
            temp.setMedicineId(donationRequest.getMedicineId());
            donationRequestRepository.save(temp);
            res.make("Sucessfull update",200,temp);
        }
        return res;
    }
}
