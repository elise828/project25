package com.example.teamproject25;
import android.content.Context;
import android.graphics.Bitmap;

import org.tensorflow.lite.Interpreter;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class DigitClassifier {
    private static final String MODEL_NAME = "digit.tflite";
    private Interpreter interpreter;

    public DigitClassifier(Context context) throws IOException {
        interpreter = new Interpreter(loadModelFile(context));
    }

    private MappedByteBuffer loadModelFile(Context context) throws IOException {
        FileInputStream fis = new FileInputStream(context.getAssets().openFd(MODEL_NAME).getFileDescriptor());
        FileChannel fileChannel = fis.getChannel();
        long startOffset = context.getAssets().openFd(MODEL_NAME).getStartOffset();
        long declaredLength = context.getAssets().openFd(MODEL_NAME).getDeclaredLength();
        return fileChannel.map(FileChannel.MapMode.READ_ONLY, startOffset, declaredLength);
    }

    public int classify(Bitmap bitmap) {
        Bitmap resized = Bitmap.createScaledBitmap(bitmap, 28, 28, true);

        ByteBuffer inputBuffer = ByteBuffer.allocateDirect(1 * 28 * 28 * 4);
        inputBuffer.order(ByteOrder.nativeOrder());

        for (int y = 0; y < 28; y++) {
            for (int x = 0; x < 28; x++) {
                int pixel = resized.getPixel(x, y);
                float normalized = (0xFF - (pixel & 0xFF)) / 255.0f;
                inputBuffer.putFloat(normalized);
            }
        }

        float[][] output = new float[1][10];
        interpreter.run(inputBuffer, output);

        int predicted = 0;
        float max = output[0][0];
        for (int i = 1; i < 10; i++) {
            if (output[0][i] > max) {
                max = output[0][i];
                predicted = i;
            }
        }

        return predicted;
    }

    public void close() {
        if (interpreter != null) {
            interpreter.close();
        }
    }
}
