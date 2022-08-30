package kazak.kirill.shoplist1.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import kazak.kirill.shoplist1.R

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MainViewModel
    private var c = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        viewModel.shopList.observe(this) {
            if (c == 0 ) {
                c++
                viewModel.changeItemsEnabledState(it[0])
            }
            Log.d("MAIN_ACT_TAG", it.toString())
        }
    }
}