package com.example.my_application_one;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import androidx.test.espresso.UiController;
import androidx.test.espresso.ViewAction;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;

import org.hamcrest.Matcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.PositionAssertions.isCompletelyAbove;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertEquals;

/**
 * Instrumented test, which will execute on an Android device and to check the android view.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class MainTest {
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



    @Test
    public void checkViews(){
        onView(withId(R.id.stopClock)).perform(click());
        onView(withId(R.id.start)).check(matches(isDisplayed()));
        onView(withId(R.id.stop)).check(matches(isDisplayed()));
        onView(withId(R.id.stop)).check(matches(isDisplayed()));
        onView(withId(R.id.timer)).check(matches(isDisplayed()));
    }

    @Test
    public void startStopResetTimer(){
        onView(withId(R.id.stopClock)).perform(click());
        onView(withId(R.id.start)).perform(click());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {}

        onView(withId(R.id.stop)).perform(click());
        try {
            //Give the clock time to settle
            Thread.sleep(1000);
        } catch (InterruptedException e) {}

        String timeNow = getText(withId(R.id.timer));
        onView(withId(R.id.timer)).check(matches(not(withText("00:00:00"))));

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {}

        onView(withId(R.id.timer)).check(matches(withText(timeNow)));
        onView(withId(R.id.start)).perform(click());

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {}

        onView(withId(R.id.timer)).check(matches(not(withText(timeNow))));

        onView(withId(R.id.reset)).perform(click());

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {}

        onView(withId(R.id.timer)).check(matches(withText("00:00:00")));
    }

    // Thanks StackOverflow for this!
    // https://stackoverflow.com/questions/23381459/how-to-get-text-from-textview-using-espresso
    String getText(final Matcher<View> matcher) {
        final String[] stringHolder = { null };
        onView(matcher).perform(new ViewAction() {
            @Override
            public Matcher<View> getConstraints() {
                return isAssignableFrom(TextView.class);
            }

            @Override
            public String getDescription() {
                return "getting text from a TextView";
            }

            @Override
            public void perform(UiController uiController, View view) {
                TextView tv = (TextView)view; //Save, because of check in getConstraints()
                stringHolder[0] = tv.getText().toString();
            }
        });
        return stringHolder[0];
    }

}