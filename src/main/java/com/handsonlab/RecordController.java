package com.handsonlab;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "${app.cors-allowed-origin:http://localhost:5173}")
public class RecordController {
    private final JdbcTemplate jdbcTemplate;

    public RecordController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping("/records")
    public List<Map<String, Object>> records() {
        return jdbcTemplate.queryForList("SELECT id, name FROM app_records ORDER BY id");
    }
}
