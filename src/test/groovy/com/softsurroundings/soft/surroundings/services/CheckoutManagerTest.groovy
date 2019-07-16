package com.softsurroundings.soft.surroundings.services

import com.softsurroundings.soft.surroundings.builders.CheckedOutBuilder
import com.softsurroundings.soft.surroundings.models.CheckedOut
import org.apache.commons.lang3.RandomStringUtils
import spock.lang.Specification

class CheckoutManagerTest extends Specification {


    def "isCheckedOut"() {
        given:

        CheckedOut scanned = CheckedOutBuilder.aCheckedOut()
                .withScannerId(RandomStringUtils.randomAlphanumeric(5))
                .withUserId(RandomStringUtils.randomAlphanumeric(5))
                .build();


        List<CheckedOut> allEntries = Arrays.asList(scanned);


        when:

        boolean isCheckout = CheckoutManager.isCheckedOut(scanned, allEntries)


        then:

        isCheckout

    }




}
