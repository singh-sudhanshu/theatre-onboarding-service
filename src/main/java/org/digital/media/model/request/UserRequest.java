package org.digital.media.model.request;

import org.digital.media.annotation.DateValidator;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Locale;

public record UserRequest(@DateValidator LocalDate dateOfBirth, String name, String contactNumber,
                          String emailId) implements Serializable {

    // This will be called during deserialization as well
    public UserRequest(
            LocalDate dateOfBirth,
            String name,
            String contactNumber,
            String emailId
    ) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("name is blank");
        }
        this.dateOfBirth = dateOfBirth;
        this.name = name.trim();
        this.contactNumber = contactNumber;
        this.emailId = emailId.toLowerCase(Locale.ROOT);
    }
}
