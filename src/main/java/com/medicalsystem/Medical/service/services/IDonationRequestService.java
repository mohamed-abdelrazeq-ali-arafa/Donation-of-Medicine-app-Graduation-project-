package com.medicalsystem.Medical.service.services;

import com.medicalsystem.Medical.service.Response;
import com.medicalsystem.Medical.service.entity.DonationRequest;

import java.util.List;

public interface IDonationRequestService {

     public Response<DonationRequest> addDonationRequest(DonationRequest donationRequest);
     public Response<DonationRequest> deleteDonationRequest(String id);
     public Response<DonationRequest> getDonationRequest(String id);
     public Response<List<DonationRequest>> getAllDonationRequest();
     public Response<DonationRequest> updateDonationRequest(String id,DonationRequest donationRequest);

}
