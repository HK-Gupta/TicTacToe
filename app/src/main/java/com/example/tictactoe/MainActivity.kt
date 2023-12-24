package com.example.tictactoe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.tictactoe.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var flag = 1
    private var count = 0
    private lateinit var buttonStr: Array<String>
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        buttonStr = Array(10) { "" }
        binding.successAlertDialog.visibility = View.GONE

        binding.btnRestart.setOnClickListener {
            startNewGame()
        }
    }

    fun click(view: View) {
        val currentButton: Button = view as Button

        if(currentButton.text.toString() == "") {
            count++
            if (flag == 1) {
                currentButton.text = "X"
                flag = 2
            } else {
                currentButton.text = "O"
                flag = 1
            }

            if (count > 4) {
                buttonStr[1] = binding.btn1.text.toString()
                buttonStr[2] = binding.btn2.text.toString()
                buttonStr[3] = binding.btn3.text.toString()
                buttonStr[4] = binding.btn4.text.toString()
                buttonStr[5] = binding.btn5.text.toString()
                buttonStr[6] = binding.btn6.text.toString()
                buttonStr[7] = binding.btn7.text.toString()
                buttonStr[8] = binding.btn8.text.toString()
                buttonStr[9] = binding.btn9.text.toString()

                var i = 1;
                // For Horizontal Checking.
                while (i <= 9) {
                    if (buttonStr[i] == buttonStr[i + 1] && buttonStr[i] == buttonStr[i + 2] && buttonStr[i] != "") {
                        binding.successAlertDialog.visibility = View.VISIBLE
                        binding.textMessage.text = if (flag == 1) getString(R.string.success1) else getString(R.string.success2)
                        binding.buttonAction.setOnClickListener {
                            startNewGame()
                        }
                    }
                    i += 3
                }

                i = 1
                // For Vertical Checking.
                while (i <= 3) {
                    if (buttonStr[i] == buttonStr[i + 3] && buttonStr[i] == buttonStr[i + 6] && buttonStr[i] != "") {
                        binding.successAlertDialog.visibility = View.VISIBLE
                        binding.textMessage.text = if (flag == 1) getString(R.string.success1) else getString(R.string.success2)
                        binding.buttonAction.setOnClickListener {
                            startNewGame()
                        }
                    }
                    i++
                }

                // For Diagonal Checking.
                if ((buttonStr[1] == buttonStr[5] && buttonStr[1] == buttonStr[9] && buttonStr[1] != "") ||
                    (buttonStr[3] == buttonStr[5] && buttonStr[3] == buttonStr[7] && buttonStr[3] != "")
                ) {
                    binding.successAlertDialog.visibility = View.VISIBLE
                    binding.textMessage.text = if (flag == 1) getString(R.string.success1) else getString(R.string.success2)
                    binding.buttonAction.setOnClickListener {
                        startNewGame()
                    }
                }

            }
            if (count == 9) {
                binding.successAlertDialog.visibility = View.VISIBLE
                binding.textTitle.text = "DRAW"
                binding.textMessage.text = getString(R.string.drawn)
                binding.buttonAction.setOnClickListener {
                    startNewGame()
                }
            }
        }

    }

    private fun startNewGame() {
        this.flag = 1
        count = 0
        binding.btn1.text = ""
        binding.btn2.text = ""
        binding.btn3.text = ""
        binding.btn4.text = ""
        binding.btn5.text = ""
        binding.btn6.text = ""
        binding.btn7.text = ""
        binding.btn8.text = ""
        binding.btn9.text = ""
        binding.successAlertDialog.visibility = View.GONE
    }
}