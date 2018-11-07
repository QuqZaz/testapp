package ru.ertelecom.testapplication.presentation.ui.activity

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import kotlinx.android.synthetic.main.activity_main.*
import ru.ertelecom.testapplication.R
import ru.ertelecom.testapplication.domain.model.WeatherItem
import ru.ertelecom.testapplication.presentation.App
import ru.ertelecom.testapplication.presentation.presentation.presenter.MainPresenter
import ru.ertelecom.testapplication.presentation.presentation.view.MainView
import ru.ertelecom.testapplication.presentation.ui.adapter.WeatherAdapter
import javax.inject.Inject

class MainActivity : MvpAppCompatActivity(), MainView {

    @Inject
    @InjectPresenter
    lateinit var presenter: MainPresenter

    @ProvidePresenter
    fun providesPresenter(): MainPresenter = presenter

    private val adapter: WeatherAdapter = WeatherAdapter()


    override fun onCreate(savedInstanceState: Bundle?) {
        (application as App).component.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        weatherList.adapter = adapter
        weatherList.layoutManager = LinearLayoutManager(this)

        swiperefresh.setOnRefreshListener {
            presenter.loadData()
        }
    }

    override fun setWeather(it: List<WeatherItem>?) {
        adapter.submitList(it)
    }

    override fun setProgress(it: Boolean) {
        swiperefresh.isRefreshing = it
    }
}
