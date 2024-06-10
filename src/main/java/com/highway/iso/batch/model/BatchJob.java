package com.highway.iso.batch.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.ResultSet;
import java.sql.SQLException;

@Getter
@Setter
@AllArgsConstructor
public class BatchJob {
    private long id;
    private String name;
    private String status;

    public BatchJob(ResultSet resultSet) throws SQLException {
        this.id = resultSet.getLong("JOB_EXECUTION_ID");
        this.name = resultSet.getString("JOB_NAME");
        this.status = resultSet.getString("STATUS");
    }
}
