package com.esoft.pcs.controller;

import com.esoft.pcs.dto.ResponseDto;
import com.esoft.pcs.models.PaddyTransfer;
import com.esoft.pcs.service.PaddyTransferService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/PaddyTransfer")
@Slf4j
public class PaddyTransferController
{
    @Autowired
    private PaddyTransferService paddyTransferService;

    @GetMapping
    public ResponseEntity<?> GetAllPaddyTransfer()
    {
        return new ResponseEntity<>(new ResponseDto(paddyTransferService.GetAllPaddyTransfer(), HttpStatus.OK), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<?> SavePaddyTransfer(@RequestBody PaddyTransfer paddyTransfer)
    {
        return new ResponseEntity<>(new ResponseDto(paddyTransferService.SavePaddyTransfer(paddyTransfer), HttpStatus.OK), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> UpdatePaddyTransfer(@RequestBody PaddyTransfer paddyTransfer)
    {
        return new ResponseEntity<>(new ResponseDto(paddyTransferService.UpdatePaddyTransfer(paddyTransfer), HttpStatus.OK), HttpStatus.OK);
    }
}
