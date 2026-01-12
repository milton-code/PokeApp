package com.proyecto.pokeapp

import android.os.Bundle
import android.view.ViewGroup
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintSet
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.updateLayoutParams
import androidx.core.view.updatePadding
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.google.android.material.appbar.MaterialToolbar

class MainActivity : AppCompatActivity() {
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val mainContainer = findViewById<android.view.View>(R.id.main)
        val topAppBar = findViewById<MaterialToolbar>(R.id.topAppBar)
        // El listener ahora es más sencillo
        ViewCompat.setOnApplyWindowInsetsListener(mainContainer) { view, windowInsets ->
            val insets = windowInsets.getInsets(WindowInsetsCompat.Type.systemBars())
            // Ya NO necesitas ajustar la topAppBar aquí.
            // Solo ajustamos el padding lateral e inferior del contenedor principal.
            view.updatePadding(
                left = insets.left,
                right = insets.right,
                bottom = insets.bottom
            )
            // 2. Ajusta explícitamente la altura y el padding de la Toolbar
            // Usamos updateLayoutParams para añadir el inset superior a la altura original de la Toolbar
            topAppBar.updateLayoutParams<ViewGroup.MarginLayoutParams> {
                height = (resources.getDimension(R.dimen.toolbar_height) + insets.top).toInt()
            }
            // Y aplicamos padding superior para empujar el contenido (título y botones) hacia abajo
            topAppBar.updatePadding(top = insets.top)

            WindowInsetsCompat.CONSUMED
        }
        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment

        navController = navHostFragment.navController

        setSupportActionBar(topAppBar)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}