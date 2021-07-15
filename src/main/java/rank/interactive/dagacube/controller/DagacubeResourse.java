package rank.interactive.dagacube.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import rank.interactive.dagacube.dto.DagacubeRequest;
import rank.interactive.dagacube.dto.DagacubeResponse;
import rank.interactive.dagacube.dto.TransactionReportRequest;
import rank.interactive.dagacube.dto.TransactionReportResponse;
import rank.interactive.dagacube.service.DagacubeServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/dagacube")
public class DagacubeResourse {

    @Autowired
    private DagacubeServiceImpl service;


    @GetMapping(value = "/getPlayerBalance/{id}")
    public ResponseEntity<DagacubeResponse> getPlayerBalance(@Validated @PathVariable long id) {
        return new ResponseEntity<>(service.getPlayerBalance(id), HttpStatus.OK);
    }

    @PostMapping(value = "/wagering")
    public ResponseEntity<DagacubeResponse> withdraw(@Validated @RequestBody DagacubeRequest request) {
        return new ResponseEntity<>(service.withdraw(request), HttpStatus.OK);
    }

    @PostMapping(value = "/winning")
    public ResponseEntity<DagacubeResponse> deposit(@Validated @RequestBody DagacubeRequest request) {
        return new ResponseEntity<>(service.deposit(request), HttpStatus.OK);
    }

    @PostMapping(value = "/transactions/report")
    public ResponseEntity<List<TransactionReportResponse>> transactionsReport(@Validated @RequestBody TransactionReportRequest request) {
        return new ResponseEntity<>(service.winTransactions(request), HttpStatus.OK);
    }

}
