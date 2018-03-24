package th.ac.lannapoly.polytechlanna

import android.net.Uri
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase



class MainActivity : AppCompatActivity(),
        HomeFragment.OnFragmentInteractionListener,
        ContactFragment.OnFragmentInteractionListener
{

    var homeFragment: HomeFragment? = null
    var contactFragment: ContactFragment? = null

    override fun onFragmentInteraction(uri: Uri) {

    }


    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                if(homeFragment == null) {
                    homeFragment = HomeFragment()
                }
                val transaction = supportFragmentManager.beginTransaction()
                transaction.replace(R.id.frameLayout, homeFragment)
//                transaction.addToBackStack(null)
                transaction.commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_promotion -> {
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                if(contactFragment == null) {
                    contactFragment = ContactFragment()
                }
                val transaction = supportFragmentManager.beginTransaction()
                transaction.replace(R.id.frameLayout, contactFragment)
//                transaction.addToBackStack(null)
                transaction.commit()
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        homeFragment = HomeFragment()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frameLayout, homeFragment)
//        transaction.addToBackStack(null)
        transaction.commit()


    }
}
