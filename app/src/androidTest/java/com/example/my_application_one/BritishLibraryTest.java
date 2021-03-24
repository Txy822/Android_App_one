package com.example.my_application_one;

import androidx.test.core.app.ActivityScenario;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.clearText;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.PositionAssertions.isCompletelyAbove;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class BritishLibraryTest {

    /**
    @Rule
    public ActivityScenarioRule<MainActivity> activityRule = new ActivityScenarioRule <>(MainActivity.class);

    @Test
    public void checkLayout() {
        onView(withId(R.id.britishLibrary)).perform(click());
        onView(withId(R.id.borrowLabel)).check(matches(isDisplayed()));
        onView(withId(R.id.borrowerID)).check(matches(isDisplayed()));
        onView(withId(R.id.setBorrowerID)).check(matches(isDisplayed()));

        onView(withId(R.id.borrowLabel)).check(isCompletelyAbove(withId(R.id.borrowerID)));
        onView(withId(R.id.borrowLabel)).check(isCompletelyAbove(withId(R.id.setBorrowerID)));
        onView(withId(R.id.borrowerID)).check(isCompletelyAbove(withId(R.id.setBorrowerID)));
    }

    @Test
    public void checkSharedPref() {
        final String TEST_ID= "a_very_test_id";
        onView(withId(R.id.britishLibrary)).perform(click());
        onView(withId(R.id.borrowerID)).perform(clearText());
        onView(withId(R.id.borrowerID)).perform(typeText(TEST_ID));
        onView(withId(R.id.setBorrowerID)).perform(click());
        activityRule.getScenario().close();
        ActivityScenario.launch(MainActivity.class);
        onView(withId(R.id.britishLibrary)).perform(click());
        onView(withId(R.id.borrowerID)).check(matches(withText(TEST_ID)));
    }
**/

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

    @Test
    public void checkSharedPref() {
        final String TEST_ID= "1960";
        onView(withId(R.id.borrowerID)).perform(clearText());
        onView(withId(R.id.borrowerID)).perform(typeText(TEST_ID));
        onView(withId(R.id.setBorrowerID)).perform(click());
        activityRule.getScenario().close();
        ActivityScenario.launch(BritishLibrary.class);
        onView(withId(R.id.borrowerID)).check(matches(withText(TEST_ID)));
    }
}
