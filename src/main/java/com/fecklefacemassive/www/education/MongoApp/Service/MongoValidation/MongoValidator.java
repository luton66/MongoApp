package com.fecklefacemassive.www.education.MongoApp.Service.MongoValidation;

import com.fecklefacemassive.www.education.MongoApp.pojo.AbstractAnimeRecord;

public interface MongoValidator {
    /**
     * Checks to see if a record exists
     *
     * @return a boolean
     */
    boolean recordExists(AbstractAnimeRecord record);

    /**
     * Checks to see if a record has all required fields completed
     *
     * @return a boolean
     */
    boolean completeRecord(AbstractAnimeRecord record);

    /**
     * Checks to see if a record is valid to write to the database
     *
     * @param confirmOverwrite a boolean to confirm whether the user has opted to force an overwrite if a record exists
     * @return a boolean
     */
    boolean recordValidForWrite(AbstractAnimeRecord record, boolean confirmOverwrite);

}
