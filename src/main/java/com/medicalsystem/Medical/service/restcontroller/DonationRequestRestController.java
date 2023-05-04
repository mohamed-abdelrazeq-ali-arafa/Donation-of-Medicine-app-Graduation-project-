package com.medicalsystem.Medical.service.restcontroller;


import com.medicalsystem.Medical.service.Response;
import com.medicalsystem.Medical.service.entity.Disease;
import com.medicalsystem.Medical.service.entity.DonationRequest;
import com.medicalsystem.Medical.service.services.IDonationRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/donationrequest")
public class DonationRequestRestController {


    @Autowired
    IDonationRequestService donationRequestService;

    public DonationRequestRestController(IDonationRequestService diseaseService) {

        this.donationRequestService =diseaseService;
    }
    @RequestMapping(value= "/adddonationrequest",method = RequestMethod.POST)
    public Response<DonationRequest> addDisease(@RequestBody DonationRequest donationRequest){
        Response<DonationRequest> res= donationRequestService.addDonationRequest(donationRequest);
        return res;
    }

    @RequestMapping(value="/getdonationrequest/{theid}",method = RequestMethod.GET)
    public Response<DonationRequest> getDisease(@PathVariable String theid){
        Response<DonationRequest> res= donationRequestService.getDonationRequest(theid);
        return res;
    }


    @RequestMapping(value="/getalldonationrequest",method = RequestMethod.GET)
    public Response<List<DonationRequest>> getAllDisease(){
        Response<List<DonationRequest>> res= donationRequestService.getAllDonationRequest();
        return res;
    }


    @RequestMapping(value="/deletedonationrequest/{theid}",method = RequestMethod.DELETE)
    public Response<DonationRequest> deleteDiseaseById(@PathVariable String theid){
        Response<DonationRequest> res= donationRequestService.deleteDonationRequest(theid);
        return res;
    }

    @RequestMapping(value= "/updatedonationrequest/{theid}",method = RequestMethod.PUT)
    public Response<DonationRequest> updateMedicine(@PathVariable String theid, @RequestBody DonationRequest donationRequest){
        Response<DonationRequest> res= donationRequestService.updateDonationRequest(theid,donationRequest);
        return res;

    }











}
