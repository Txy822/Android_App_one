package com.example.my_application_one;

import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.PositionAssertions.isCompletelyAbove;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

public class BritishLibraryTest {

    @Rule
    public ActivityScenarioRule<BritishLibrary> activityRule = new ActivityScenarioRule <>(BritishLibrary.class);

    @Test
    public void checkLayout() {
        onView(withId(R.id.borrowLabel)).check(matches(isDisplayed()));
        onView(withId(R.id.borrowerID)).check(matches(isDisplayed()));
        onView(withId(R.id.setBorrowerID)).check(matches(isDisplayed()));

        onView(withId(R.id.borrowLabel)).check(isCompletelyAbove(withId(R.id.borrowerID)));
        onView(withId(R.id.borrowLabel)).check(isCompletelyAbove(withId(R.id.setBorrowerID)));
        onView(withId(R.id.borrowerID)).check(isCompletelyAbove(withId(R.id.setBorrowerID)));

    }
}
