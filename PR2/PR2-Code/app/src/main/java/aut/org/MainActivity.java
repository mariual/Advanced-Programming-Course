package aut.org;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView txt_result;
    TextView txt_history;
    Button btn_0;
    Button btn_1;
    Button btn_2;
    Button btn_3;
    Button btn_4;
    Button btn_5;
    Button btn_6;
    Button btn_7;
    Button btn_8;
    Button btn_9;
    Button btn_ce;
    Button btn_c;
    Button btn_dot;
    Button btn_equal;
    Button btn_plus;
    Button btn_minus;
    Button btn_multiply;
    Button btn_divide;
    Button btn_sign;
    Button btn_back;

    double resultVal = 0.0;
    String operand = "";
    boolean mustReset = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);


        txt_history = (TextView) findViewById(R.id.txt_history);
        txt_result = (TextView) findViewById(R.id.txt_result);
        btn_0 = (Button) findViewById(R.id.btn_0);
        btn_1 = (Button) findViewById(R.id.btn_1);
        btn_2 = (Button) findViewById(R.id.btn_2);
        btn_3 = (Button) findViewById(R.id.btn_3);
        btn_4 = (Button) findViewById(R.id.btn_4);
        btn_5 = (Button) findViewById(R.id.btn_5);
        btn_6 = (Button) findViewById(R.id.btn_6);
        btn_7 = (Button) findViewById(R.id.btn_7);
        btn_8 = (Button) findViewById(R.id.btn_8);
        btn_9 = (Button) findViewById(R.id.btn_9);
        btn_ce = (Button) findViewById(R.id.btn_ce);
        btn_c = (Button) findViewById(R.id.btn_c);
        btn_dot = (Button) findViewById(R.id.btn_dot);
        btn_equal = (Button) findViewById(R.id.btn_equal);
        btn_plus = (Button) findViewById(R.id.btn_plus);
        btn_minus = (Button) findViewById(R.id.btn_minus);
        btn_multiply = (Button) findViewById(R.id.btn_multiply);
        btn_divide = (Button) findViewById(R.id.btn_divide);
        btn_sign = (Button) findViewById(R.id.btn_sign);
        btn_back = (Button) findViewById(R.id.btn_back);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mustReset) {
                    txt_result.setText("0");
                }
                String tag = v.getTag().toString();
                if (txt_result.getText().toString().equals("0")) {
                    if (!tag.equals("0")) {
                        txt_result.setText(tag);
                    }
                } else {
                    if (txt_result.getText().toString().length() <= 9){
                        txt_result.setText(txt_result.getText().toString() + tag);
                    }
                }
                mustReset = false;
            }
        };

        btn_0.setOnClickListener(listener);
        btn_1.setOnClickListener(listener);
        btn_2.setOnClickListener(listener);
        btn_3.setOnClickListener(listener);
        btn_4.setOnClickListener(listener);
        btn_5.setOnClickListener(listener);
        btn_6.setOnClickListener(listener);
        btn_7.setOnClickListener(listener);
        btn_8.setOnClickListener(listener);
        btn_9.setOnClickListener(listener);

        btn_c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt_result.setText("0");
                txt_history.setText("");
                resultVal = 0.0;
                operand = "";
                mustReset = false;
            }
        });

        btn_ce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt_result.setText("0");
            }
        });

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mustReset) {
                    txt_result.setText("0");
                    mustReset = false;
                }
                if (!txt_result.getText().toString().equals("0")) {
                    String val = txt_result.getText().toString();
                    if (val.length()==1) {
                        txt_result.setText("0");
                    } else {
                        txt_result.setText(val.substring(0, val.length() - 1));
                    }
                }
            }
        });


        View.OnClickListener operandListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = txt_result.getText().toString();
                double val = Double.parseDouble(text);
                String tag = v.getTag().toString();
                if (val - (int)val == 0.0f) {
                    txt_history.setText(txt_history.getText().toString() + (int)val + " " + tag + " ");
                } else {
                    txt_history.setText(txt_history.getText().toString() + val + " " + tag + " ");
                }
                if (operand.equals("+")) {
                    resultVal += val;
                } else if (operand.equals("-")) {
                    resultVal -= val;
                } else if (operand.equals("*")) {
                    resultVal *= val;
                } else if (operand.equals("÷")) {
                    resultVal /= val;
                } else if (operand.equals("")) {
                    resultVal = val;
                }else if (operand.equals("%")){
                    resultVal %= val;
                }
                operand = tag;
                mustReset = true;
                if (resultVal - (int)resultVal == 0.0f) {
                    txt_result.setText("" + (int)resultVal);
                } else {
                    txt_result.setText("" + resultVal);
                }
            }
        };

        btn_plus.setOnClickListener(operandListener);
        btn_minus.setOnClickListener(operandListener);
        btn_multiply.setOnClickListener(operandListener);
        btn_divide.setOnClickListener(operandListener);
        btn_sign.setOnClickListener(operandListener);

        btn_equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double val = Double.parseDouble(txt_result.getText().toString());
                mustReset = true;
                txt_history.setText("");
                if (operand.equals("+")) {
                    resultVal += val;
                } else if (operand.equals("-")) {
                    resultVal -= val;
                } else if (operand.equals("*")) {
                    resultVal *= val;
                } else if (operand.equals("÷")) {
                    resultVal /= val;
                } else if (operand.equals("")) {
                    resultVal = val;
                }else if (operand.equals("%")){
                    resultVal %= val;
                }
                operand = "";
                if (resultVal - (int)resultVal == 0.0f) {
                    txt_result.setText("" + (int)resultVal);
                } else {
                    txt_result.setText("" + resultVal);
                }
                resultVal = 0.0;

            }
        });

        btn_dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mustReset) {
                    txt_result.setText("0.");
                    mustReset = false;
                } else {
                    if (!txt_result.getText().toString().contains(".")) {
                        txt_result.setText(txt_result.getText().toString() + ".");
                    }
                }
            }
        });
    }
}

