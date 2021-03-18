package com.example.my_application_one;

import android.content.Context;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;
import static androidx.test.espresso.Espresso.*;
import static androidx.test.espresso.action.ViewActions.*;
import static androidx.test.espresso.assertion.PositionAssertions.*;
import static androidx.test.espresso.assertion.ViewAssertions.*;

import static androidx.test.espresso.matcher.ViewMatchers.*;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device and to check the android view.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class SpinnerSelectTest {
    //final String TEST_MESSAGE = "Yeah, here is a test message.";
    final String TEST_MESSAGE = "Yeah";
    @Rule
    public ActivityScenarioRule<MainActivity> activityRule = new ActivityScenarioRule <>(MainActivity.class);

    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        //assertEquals("com.example.weekthreeapplicationtwo", appContext.getPackageName());
        assertEquals("com.example.my_application_one", appContext.getPackageName());
    }

    @Test
    public void spinnerExists() {

        onView(withId(R.id.spinner)).check(matches(isDisplayed()));

    }

    @Test
    public void spinnerAboveButton() {
        onView(withId(R.id.spinner)).check(isCompletelyAbove(withId(R.id.button)));

    }

    @Test
    public void spinnerSelectAndUpdate() {
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        String[] spinOpts = appContext.getResources().getStringArray(R.array.spinneroptions);

        String firstItem =  spinOpts[0];

        onView(withId(R.id.spinner)).perform(click());
        onData(allOf(is(instanceOf(String.class)), is(firstItem))).perform(click());
        onView(withId(R.id.button)).perform(click());
        onView(withId(R.id.textView)).check(matches(withText(firstItem)));

    }
//    @Rule
//    public ActivityScenarioRule<CreateMessageActivity> mActivityTestRule = new ActivityScenarioRule<>(CreateMessageActivity.class);

    @Test
    public void checkCreateAppearance() {
        onView(withId(R.id.send)).check(matches(isDisplayed()));
        onView(withId(R.id.send)).perform(click());
        onView(withId(R.id.message)).check(matches(isDisplayed()));
        onView(withId(R.id.send)).check(isCompletelyAbove(withId(R.id.message)));
    }

    @Test
    public void checkFillAndSend() {
        //onView(withId(R.id.message)).perform(typeText(TEST_MESSAGE));
        onView(withId(R.id.send)).perform(click());
        onView(withId(R.id.send)).check(matches(isDisplayed()));
        onView(withId(R.id.message)).perform(typeText(TEST_MESSAGE));
        onView(withId(R.id.send)).perform(click());
        onView(withId(R.id.messageReceived)).check(matches(isDisplayed()));
        onView(withId(R.id.messageReceived)).check(matches(withText(TEST_MESSAGE)));
    }

}