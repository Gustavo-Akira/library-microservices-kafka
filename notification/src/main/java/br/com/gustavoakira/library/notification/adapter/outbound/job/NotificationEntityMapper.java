package br.com.gustavoakira.library.notification.adapter.outbound.job;

import br.com.gustavoakira.library.notification.adapter.outbound.persistence.entity.NotificationEntity;

import java.sql.ResultSet;
import java.sql.SQLException;

public class NotificationEntityMapper implements org.springframework.jdbc.core.RowMapper<NotificationEntity> {
    @Override
    public NotificationEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
        return NotificationEntity.builder()
                .email(rs.getString("email"))
                .id(rs.getLong("id"))
                .message(rs.getString("message"))
                .status(rs.getString("status"))
                .build();
    }
}
