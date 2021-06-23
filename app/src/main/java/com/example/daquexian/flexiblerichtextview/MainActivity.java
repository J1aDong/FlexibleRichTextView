package com.example.daquexian.flexiblerichtextview;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.daquexian.flexiblerichtextview.Attachment;
import com.daquexian.flexiblerichtextview.FlexibleRichTextView;
import com.daquexian.flexiblerichtextview.Tokenizer;

import org.scilab.forge.jlatexmath.core.AjLatexMath;

import java.util.ArrayList;
import java.util.List;

import io.github.kbiakov.codeview.classifier.CodeProcessor;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // train classifier on app start
        CodeProcessor.init(this);
        AjLatexMath.init(this); // init library: load fonts, create paint, etc.

        List<Attachment> attachments = new ArrayList<>();
        attachments.add(new ExampleAttachment("Android Image", "53ce1", true, "http://tse1.mm.bing.net/th?id=OIP.M24baa78c1fb80a71891ce775d11e038ao0&w=166&h=166&c=7&qlt=90&o=4&pid=1.7"));
        attachments.add(new ExampleAttachment("Here is a link", "bc41a", false, "https://google.com"));

        FlexibleRichTextView flexibleRichTextView = (FlexibleRichTextView) findViewById(R.id.frtv);
        Tokenizer.setCenterStartLabels("<center>");
        Tokenizer.setCenterEndLabels("</center>");
        Tokenizer.setTitleStartLabels("<h>","<p>");
        Tokenizer.setTitleEndLabels("</h>","</p>");

        flexibleRichTextView.setText("<p> 若x，y满足约束条件\\(\\left\\{ \\begin{align} & \\text{2x}+y\\text{-}2\\leqslant 0 \\\\ & \\text{x}-y\\text{-}1\\geqslant 0 \\\\ & \\text{y}+1\\geqslant 0 \\\\ \\end{align} \\right.\\)，则z=x+7y的最大值为_____.<br />我的测试</p>");
    }
}