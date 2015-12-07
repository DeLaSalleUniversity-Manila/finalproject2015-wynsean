package wynsean.freshie;

import android.content.Intent;
import android.os.Handler;
import android.speech.RecognitionListener;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;

public class FoodCupboardActivity extends AppCompatActivity {

    LinkedHashMap<String, List<String>> category;
    List<String> list;
    ExpandableListView Exp_list;
    ExpandedListAdapter adapter;

    TextToSpeech tts;
    int result;
    String item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_cupboard);

        Exp_list = (ExpandableListView) findViewById(R.id.expandableListView);
        category = FoodCupboardDataProvider.getInfo();
        list = new ArrayList<>(category.keySet());
        adapter = new ExpandedListAdapter(this, category, list);
        Exp_list.setAdapter(adapter);

        tts = new TextToSpeech(this, new TextToSpeech.OnInitListener()
        {
            @Override
            public void onInit(int status)
            {
                if(status == TextToSpeech.SUCCESS)
                    result = tts.setLanguage(Locale.ENGLISH);    //SET LANGUAGE

            }
        });

        Exp_list.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition) {
                Reader(groupPosition);
            }
        });

        Exp_list.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                if (groupPosition == 0) {
                    if (childPosition == 0) Reader(3);
                    else if (childPosition == 1) Reader(4);
                    else if (childPosition == 2) Reader(5);
                }
                else if (groupPosition == 1) {
                    if (childPosition == 0) Reader(6);
                    else if (childPosition == 1) Reader(7);
                    else if (childPosition == 2) Reader(8);
                }
                else if (groupPosition == 2) {
                    if (childPosition == 0) Reader(9);
                    else if (childPosition == 1) Reader(10);
                    else if (childPosition == 2) Reader(11);
                }
                Intent intent = new Intent(FoodCupboardActivity.this, FoodCupboardPurchaseActivity.class);
                intent.putExtra(FoodCupboardPurchaseActivity.GROUPPOSITION, groupPosition);
                intent.putExtra(FoodCupboardPurchaseActivity.CHILDPOSITION, childPosition);
                startActivity(intent);

                return false;
            }
        });
    }

    private void Reader(int n) {
        final String[] text = {
                "tins cans and packets",
                "biscuits",
                "chocolate",
                "corned beef",
                "sardines",
                "tuna",
                "skyflakes",
                "oreos",
                "fita",
                "cadbury",
                "hershies",
                "em and ems"
        };
        if (result == TextToSpeech.LANG_NOT_SUPPORTED || result == TextToSpeech.LANG_MISSING_DATA)  //WILL NOT EMITT SOUND IF THERE"S AN ERROR
        {
            Toast.makeText(getApplicationContext(), "Text-to-Speech feature is not supported", Toast.LENGTH_SHORT).show();
        } else {
            tts.speak(text[n], TextToSpeech.QUEUE_FLUSH, null);
        }
    }

    public void onClickCart(View view) {
        Intent i = new Intent(this, ReceiptActivity.class);
        startActivity(i);
    }

    private static final String TAG = FoodCupboardActivity.class.getName();
    private SpeechRecognizer mSpeechRecognizer;
    private Handler mHandler = new Handler();
    TextView responseText;
    Intent mSpeechIntent;
    boolean killCommanded = false;

    private static final String[] VALID_COMMANDS = {
            "main menu",
            "fresh food",
            "food cupboard",
            "frozen food",
            "drinks",
            "strawberry",
            "apple",
            "banana",
            "broccoli",
            "tomato",
            "potato",
            "chicken",
            "duck",
            "turkey",
            "corned beef",
            "sardines",
            "canned tuna",
            "skyflakes",
            "oreo",
            "fita",
            "cadbury",
            "hershey",
            "m and m",
            "frozen steak",
            "frozen chicken",
            "frozen pork",
            "bangus",
            "salmon",
            "tuna",
            "magnolia ice cream",
            "magnum ice cream",
            "nestle ice cream",
            "coca cola",
            "pepsi",
            "root beer",
            "c2 iced tea",
            "orange juice",
            "grape juice",
            "absolute bottled water",
            "summit bottled water",
            "nature spring bottled water",
            "shopping cart"
    };
    private static final int VALID_COMMANDS_SIZE = VALID_COMMANDS.length;

    public void onClickMic(View view) {
        mSpeechRecognizer = SpeechRecognizer.createSpeechRecognizer(this);
        SpeechListener mRecognitionListener = new SpeechListener();
        mSpeechRecognizer.setRecognitionListener(mRecognitionListener);
        mSpeechIntent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);

        mSpeechIntent.putExtra(RecognizerIntent.EXTRA_CALLING_PACKAGE,"wynsean.freshie");

        mSpeechIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);

        mSpeechIntent.putExtra(RecognizerIntent.EXTRA_MAX_RESULTS, 20);

        mSpeechIntent.putExtra(RecognizerIntent.EXTRA_PARTIAL_RESULTS, true);

        mSpeechRecognizer.startListening(mSpeechIntent);

    }

    private void getResponse(int command){

        Intent i;
        String retString =  "I'm sorry, Sean. I'm afraid I can't do that.";
        switch (command) {
            case 0:
                i = new Intent(this, MainMenu.class);
                startActivity(i);
                break;
            case 1:
                i = new Intent(this, FreshFoodActivity.class);
                startActivity(i);
                break;
            case 2:
                i = new Intent(this, FoodCupboardActivity.class);
                startActivity(i);
                break;
            case 3:
                i = new Intent(this, FrozenFoodActivity.class);
                startActivity(i);
                break;
            case 4:
                i = new Intent(this, DrinksActivity.class);
                startActivity(i);
                break;
            case 5:
                i = new Intent(this, FreshFoodPurchaseActivity.class);
                i.putExtra(FreshFoodPurchaseActivity.GROUPPOSITION, 0);
                i.putExtra(FreshFoodPurchaseActivity.CHILDPOSITION, 0);
                startActivity(i);
                break;
            case 6:
                i = new Intent(this, FreshFoodPurchaseActivity.class);
                i.putExtra(FreshFoodPurchaseActivity.GROUPPOSITION, 0);
                i.putExtra(FreshFoodPurchaseActivity.CHILDPOSITION, 1);
                startActivity(i);
                break;
            case 7:
                i = new Intent(this, FreshFoodPurchaseActivity.class);
                i.putExtra(FreshFoodPurchaseActivity.GROUPPOSITION, 0);
                i.putExtra(FreshFoodPurchaseActivity.CHILDPOSITION, 2);
                startActivity(i);
                break;
            case 8:
                i = new Intent(this, FreshFoodPurchaseActivity.class);
                i.putExtra(FreshFoodPurchaseActivity.GROUPPOSITION, 1);
                i.putExtra(FreshFoodPurchaseActivity.CHILDPOSITION, 0);
                startActivity(i);
                break;
            case 9:
                i = new Intent(this, FreshFoodPurchaseActivity.class);
                i.putExtra(FreshFoodPurchaseActivity.GROUPPOSITION, 1);
                i.putExtra(FreshFoodPurchaseActivity.CHILDPOSITION, 1);
                startActivity(i);
                break;
            case 10:
                i = new Intent(this, FreshFoodPurchaseActivity.class);
                i.putExtra(FreshFoodPurchaseActivity.GROUPPOSITION, 1);
                i.putExtra(FreshFoodPurchaseActivity.CHILDPOSITION, 2);
                startActivity(i);
                break;
            case 11:
                i = new Intent(this, FreshFoodPurchaseActivity.class);
                i.putExtra(FreshFoodPurchaseActivity.GROUPPOSITION, 2);
                i.putExtra(FreshFoodPurchaseActivity.CHILDPOSITION, 0);
                startActivity(i);
                break;
            case 12:
                i = new Intent(this, FreshFoodPurchaseActivity.class);
                i.putExtra(FreshFoodPurchaseActivity.GROUPPOSITION, 2);
                i.putExtra(FreshFoodPurchaseActivity.CHILDPOSITION, 1);
                startActivity(i);
                break;
            case 13:
                i = new Intent(this, FreshFoodPurchaseActivity.class);
                i.putExtra(FreshFoodPurchaseActivity.GROUPPOSITION, 2);
                i.putExtra(FreshFoodPurchaseActivity.CHILDPOSITION, 2);
                startActivity(i);
                break;
            case 14:
                i = new Intent(this, FoodCupboardPurchaseActivity.class);
                i.putExtra(FoodCupboardPurchaseActivity.GROUPPOSITION, 0);
                i.putExtra(FoodCupboardPurchaseActivity.CHILDPOSITION, 0);
                startActivity(i);
                break;
            case 15:
                i = new Intent(this, FoodCupboardPurchaseActivity.class);
                i.putExtra(FoodCupboardPurchaseActivity.GROUPPOSITION, 0);
                i.putExtra(FoodCupboardPurchaseActivity.CHILDPOSITION, 1);
                startActivity(i);
                break;
            case 16:
                i = new Intent(this, FoodCupboardPurchaseActivity.class);
                i.putExtra(FoodCupboardPurchaseActivity.GROUPPOSITION, 0);
                i.putExtra(FoodCupboardPurchaseActivity.CHILDPOSITION, 2);
                startActivity(i);
                break;
            case 17:
                i = new Intent(this, FoodCupboardPurchaseActivity.class);
                i.putExtra(FoodCupboardPurchaseActivity.GROUPPOSITION, 1);
                i.putExtra(FoodCupboardPurchaseActivity.CHILDPOSITION, 0);
                startActivity(i);
                break;
            case 18:
                i = new Intent(this, FoodCupboardPurchaseActivity.class);
                i.putExtra(FoodCupboardPurchaseActivity.GROUPPOSITION, 1);
                i.putExtra(FoodCupboardPurchaseActivity.CHILDPOSITION, 1);
                startActivity(i);
                break;
            case 19:
                i = new Intent(this, FoodCupboardPurchaseActivity.class);
                i.putExtra(FoodCupboardPurchaseActivity.GROUPPOSITION, 1);
                i.putExtra(FoodCupboardPurchaseActivity.CHILDPOSITION, 2);
                startActivity(i);
                break;
            case 20:
                i = new Intent(this, FoodCupboardPurchaseActivity.class);
                i.putExtra(FoodCupboardPurchaseActivity.GROUPPOSITION, 2);
                i.putExtra(FoodCupboardPurchaseActivity.CHILDPOSITION, 0);
                startActivity(i);
                break;
            case 21:
                i = new Intent(this, FoodCupboardPurchaseActivity.class);
                i.putExtra(FoodCupboardPurchaseActivity.GROUPPOSITION, 2);
                i.putExtra(FoodCupboardPurchaseActivity.CHILDPOSITION, 1);
                startActivity(i);
                break;
            case 22:
                i = new Intent(this, FoodCupboardPurchaseActivity.class);
                i.putExtra(FoodCupboardPurchaseActivity.GROUPPOSITION, 2);
                i.putExtra(FoodCupboardPurchaseActivity.CHILDPOSITION, 2);
                startActivity(i);
                break;
            case 23:
                i = new Intent(this, FrozenFoodPurchaseActivity.class);
                i.putExtra(FrozenFoodPurchaseActivity.GROUPPOSITION, 0);
                i.putExtra(FrozenFoodPurchaseActivity.CHILDPOSITION, 0);
                startActivity(i);
                break;
            case 24:
                i = new Intent(this, FrozenFoodPurchaseActivity.class);
                i.putExtra(FrozenFoodPurchaseActivity.GROUPPOSITION, 0);
                i.putExtra(FrozenFoodPurchaseActivity.CHILDPOSITION, 1);
                startActivity(i);
                break;
            case 25:
                i = new Intent(this, FrozenFoodPurchaseActivity.class);
                i.putExtra(FrozenFoodPurchaseActivity.GROUPPOSITION, 0);
                i.putExtra(FrozenFoodPurchaseActivity.CHILDPOSITION, 2);
                startActivity(i);
                break;
            case 26:
                i = new Intent(this, FrozenFoodPurchaseActivity.class);
                i.putExtra(FrozenFoodPurchaseActivity.GROUPPOSITION, 1);
                i.putExtra(FrozenFoodPurchaseActivity.CHILDPOSITION, 0);
                startActivity(i);
                break;
            case 27:
                i = new Intent(this, FrozenFoodPurchaseActivity.class);
                i.putExtra(FrozenFoodPurchaseActivity.GROUPPOSITION, 1);
                i.putExtra(FrozenFoodPurchaseActivity.CHILDPOSITION, 1);
                startActivity(i);
                break;
            case 28:
                i = new Intent(this, FrozenFoodPurchaseActivity.class);
                i.putExtra(FrozenFoodPurchaseActivity.GROUPPOSITION, 1);
                i.putExtra(FrozenFoodPurchaseActivity.CHILDPOSITION, 2);
                startActivity(i);
                break;
            case 29:
                i = new Intent(this, FrozenFoodPurchaseActivity.class);
                i.putExtra(FrozenFoodPurchaseActivity.GROUPPOSITION, 2);
                i.putExtra(FrozenFoodPurchaseActivity.CHILDPOSITION, 0);
                startActivity(i);
                break;
            case 30:
                i = new Intent(this, FrozenFoodPurchaseActivity.class);
                i.putExtra(FrozenFoodPurchaseActivity.GROUPPOSITION, 2);
                i.putExtra(FrozenFoodPurchaseActivity.CHILDPOSITION, 1);
                startActivity(i);
                break;
            case 31:
                i = new Intent(this, FrozenFoodPurchaseActivity.class);
                i.putExtra(FrozenFoodPurchaseActivity.GROUPPOSITION, 2);
                i.putExtra(FrozenFoodPurchaseActivity.CHILDPOSITION, 2);
                startActivity(i);
                break;
            case 32:
                i = new Intent(this, DrinksPurchaseActivity.class);
                i.putExtra(DrinksPurchaseActivity.GROUPPOSITION, 0);
                i.putExtra(DrinksPurchaseActivity.CHILDPOSITION, 0);
                startActivity(i);
                break;
            case 33:
                i = new Intent(this, DrinksPurchaseActivity.class);
                i.putExtra(DrinksPurchaseActivity.GROUPPOSITION, 0);
                i.putExtra(DrinksPurchaseActivity.CHILDPOSITION, 1);
                startActivity(i);
                break;
            case 34:
                i = new Intent(this, DrinksPurchaseActivity.class);
                i.putExtra(DrinksPurchaseActivity.GROUPPOSITION, 0);
                i.putExtra(DrinksPurchaseActivity.CHILDPOSITION, 2);
                startActivity(i);
                break;
            case 35:
                i = new Intent(this, DrinksPurchaseActivity.class);
                i.putExtra(DrinksPurchaseActivity.GROUPPOSITION, 1);
                i.putExtra(DrinksPurchaseActivity.CHILDPOSITION, 0);
                startActivity(i);
                break;
            case 36:
                i = new Intent(this, DrinksPurchaseActivity.class);
                i.putExtra(DrinksPurchaseActivity.GROUPPOSITION, 1);
                i.putExtra(DrinksPurchaseActivity.CHILDPOSITION, 1);
                startActivity(i);
                break;
            case 37:
                i = new Intent(this, DrinksPurchaseActivity.class);
                i.putExtra(DrinksPurchaseActivity.GROUPPOSITION, 1);
                i.putExtra(DrinksPurchaseActivity.CHILDPOSITION, 2);
                startActivity(i);
                break;
            case 38:
                i = new Intent(this, DrinksPurchaseActivity.class);
                i.putExtra(DrinksPurchaseActivity.GROUPPOSITION, 2);
                i.putExtra(DrinksPurchaseActivity.CHILDPOSITION, 0);
                startActivity(i);
                break;
            case 39:
                i = new Intent(this, DrinksPurchaseActivity.class);
                i.putExtra(DrinksPurchaseActivity.GROUPPOSITION, 2);
                i.putExtra(DrinksPurchaseActivity.CHILDPOSITION, 1);
                startActivity(i);
                break;
            case 40:
                i = new Intent(this, DrinksPurchaseActivity.class);
                i.putExtra(DrinksPurchaseActivity.GROUPPOSITION, 2);
                i.putExtra(DrinksPurchaseActivity.CHILDPOSITION, 2);
                startActivity(i);
                break;
            case 41:
                i = new Intent(this, ReceiptActivity.class);
                startActivity(i);
                break;

//            case 4:
//                killCommanded = true;
//                break;

            default:
                break;
        }
    }

    private void processCommand(ArrayList<String> matchStrings){
//        String response = "I'm sorry, Dave. I'm afraid I can't do that.";
        int index = -1;
        int maxStrings = matchStrings.size();
        boolean resultFound = false;
        for(int i =0; i < VALID_COMMANDS_SIZE && !resultFound;i++){
            for(int j=0; j < maxStrings && !resultFound; j++){
                if(StringUtils.getLevenshteinDistance(matchStrings.get(j), VALID_COMMANDS[i]) <(VALID_COMMANDS[i].length() / 3) ){
                    index = i;
                }
            }
        }

//        final String finalResponse = response;

        if (index >= 0) {
            final int finalIndex = index;
            mHandler.post(new Runnable() {
                public void run() {
                    getResponse(finalIndex);
                }
            });
        }
        else {
            Toast toast = Toast.makeText(getApplicationContext(), "Not Found", Toast.LENGTH_SHORT);
            toast.show();
        }


    }

    class SpeechListener implements RecognitionListener {
        public void onBufferReceived(byte[] buffer) {
            Log.d(TAG, "buffer recieved ");
        }
        public void onError(int error) {
            //if critical error then exit
            if(error == SpeechRecognizer.ERROR_CLIENT || error == SpeechRecognizer.ERROR_INSUFFICIENT_PERMISSIONS){
                Log.d(TAG, "client error");
            }
            //else ask to repeats
            else{
                Log.d(TAG, "other error");
                Toast toast = Toast.makeText(getApplicationContext(), "error, try again", Toast.LENGTH_SHORT);
                toast.show();
//                mSpeechRecognizer.startListening(mSpeechIntent);
            }
        }
        public void onEvent(int eventType, Bundle params) {
            Log.d(TAG, "onEvent");
        }
        public void onPartialResults(Bundle partialResults) {
            Log.d(TAG, "partial results");
        }
        public void onReadyForSpeech(Bundle params) {
            Toast toast = Toast.makeText(getApplicationContext(), "Start Speaking", Toast.LENGTH_SHORT);
            toast.show();
            Log.d(TAG, "on ready for speech");
        }
        public void onResults(Bundle results) {
            Log.d(TAG, "on results");
            ArrayList<String> matches = null;
            if(results != null){
                matches = results.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION);
                if(matches != null){
                    Log.d(TAG, "results are " + matches.toString());
                    final ArrayList<String> matchesStrings = matches;
                    processCommand(matchesStrings);
//                    if(!killCommanded)
//
//                        mSpeechRecognizer.startListening(mSpeechIntent);
//                    else
//                        finish();

                }
            }

        }
        public void onRmsChanged(float rmsdB) {
            //			Log.d(TAG, "rms changed");
        }
        public void onBeginningOfSpeech() {
            Log.d(TAG, "speach begining");
        }
        public void onEndOfSpeech() {
            Toast toast = Toast.makeText(getApplicationContext(), "Speaking Done", Toast.LENGTH_SHORT);
            toast.show();
            Log.d(TAG, "speach done");
        }

    }
}
