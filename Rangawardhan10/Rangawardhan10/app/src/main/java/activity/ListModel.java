package activity;

import com.example.akashj.rangawardhan10.R;

final class ListModel {

    private static final String[] MODEL = {
            "Zero",
            "One",
            "Two",
            "Three",
            "Four",
            "Five",
            "Six",
            "Seven",
            "Eight",
            "Nine",
            "Ten",
            "Eleven",
            "Twelve",
            "Thirteen",
            "Fourteen",
            "Fifteen",
            "Sixteen",
            "Seventeen",
            "Eighteen",
            "Nineteen",
            "Twenty",
            "Twentyone",
            "Twentytwo",
            "Twentythree",
            "Twentyfour",
            "Twentyfive",
            "Twentysix",
            "Twentyseven",
            "Twentyeight",
            "Twentynine",
            "Thirty",
            "Thirtyone",
            "Thirtytwo",
            "Thirtythree",
            "Thirtyfour",
            "Thirtyfive",
            "Thirtysix",
            "Thirtyseven",
            "Thirtyeight",
            "Thirtynine",
            "Forty",
            "Fortyone",
            "Fortytwo",
            "Fortythree",
            "Fortyfour",
            "Fortyfive",
            "Fortysix",
            "Fortyseven",
            "Fortyeight",
            "Fortynine",
            "Fifty",
            "Fiftyone",
            "Fiftytwo",
            "Fiftythree",
            "Fiftyfour",
            "Fiftyfive",
            "Fiftysix",
            "Fiftyseven",
            "Fiftyeight",
            "Fiftynine",
            "Sixty",
            "Sixtyone",
            "Sixtytwo",
            "Sixtythree",
            "Sixtyfour",
            "Sixtyfive",
            "Sixtysix",
            "Sixtyseven",
            "Sixtyeight",
            "Sixtynine",
            "Seventy",
            "Seventyone",
            "Seventytwo",
            "Seventythree",
            "Seventyfour",
            "Seventyfive",
            "Seventysix",
            "Seventyseven",
            "Seventyeight",
            "Seventynine",
            "Eighty",
            "Eightyone",
            "Eightytwo",
            "Eightythree",
            "Eightyfour",
            "Eightyfive",
            "Eightysix",
            "Eightyseven",
            "Eightyeight",
            "Eightynine",
            "Ninety",
            "Ninetyone",
            "Ninetytwo",
            "Ninetythree",
            "Ninetyfour",
            "Ninetyfive",
            "Ninetysix",
            "Ninetyseven",
            "Ninetyeight",
            "Ninetynine"
    };

   /* private static int[] MODEL_IMAGE={R.drawable.dp2,R.drawable.thumb1,R.drawable.dp2,R.drawable.thumb1,
            R.drawable.dp2,R.drawable.thumb1,R.drawable.dp2,R.drawable.thumb1,
            R.drawable.dp2,R.drawable.thumb1,R.drawable.dp2,R.drawable.thumb1,
            R.drawable.dp2,R.drawable.thumb1,R.drawable.dp2,R.drawable.thumb1,R.drawable.thumb1,
            R.drawable.dp2,R.drawable.thumb1,R.drawable.thumb1,R.drawable.dp2,R.drawable.thumb1,
            R.drawable.dp2,R.drawable.thumb1,R.drawable.thumb1,R.drawable.dp2,R.drawable.thumb1,
            R.drawable.dp2,R.drawable.thumb1,R.drawable.thumb1,R.drawable.dp2,R.drawable.thumb1,
            R.drawable.dp2,R.drawable.thumb1,R.drawable.thumb1,R.drawable.dp2,R.drawable.thumb1,
            R.drawable.dp2,R.drawable.thumb1,R.drawable.thumb1,R.drawable.dp2,R.drawable.thumb1
            };*/

    private static int[] MODEL_IMAGE={R.drawable.g1,R.drawable.g2,R.drawable.g3,
            R.drawable.g4,R.drawable.g5,R.drawable.g6,R.drawable.g7,R.drawable.g8,
            R.drawable.g9, R.drawable.g10,R.drawable.g11,R.drawable.g12,R.drawable.g13,R.drawable.g14,R.drawable.g15
    };

    public static int[] getModelImage() {
        return MODEL_IMAGE;
    }


    public static String[] getModel() {
        return MODEL;
    }

    public static String getModelItem(int position) {
        return MODEL[position];
    }

    public static int getModelImageItem(int position) {
        return MODEL_IMAGE[position];
    }

    private ListModel() { }

    private static int[] EVENT_IMAGES_ID = {R.drawable.kawadasa, R.drawable.nrutya, R.drawable.gane,
            R.drawable.pathnatya, R.drawable.vadvivad,  R.drawable.ekpatri,
            R.drawable.kavya, R.drawable.vadyavadan};

    public static int[] getEventImagesIdArray() {
        return EVENT_IMAGES_ID;
    }
    public static int getEventImageId(int position){
        return EVENT_IMAGES_ID[position];
    }



}
