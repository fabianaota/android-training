package io.redspark.redstest.modules.exam.router;

import androidx.fragment.app.Fragment
import io.redspark.redstest.modules.viper_plugin.errors.ViperModuleAssemblerException
import io.redspark.redstest.modules.viper_plugin.extensions.instantiateAndBindViewModel
import io.redspark.redstest.modules.viper_plugin.interfaces.ModuleAssembler
import io.redspark.redstest.modules.exam.contracts.ExamContracts
import io.redspark.redstest.modules.exam.datamanager.ExamRemoteDataManager
import io.redspark.redstest.modules.exam.interactor.ExamInteractor
import io.redspark.redstest.modules.exam.presenter.ExamPresenter
import io.redspark.redstest.modules.exam.view.ExamFragment

class ExamRouter(
    val fragment: Fragment
) : ExamContracts.Router {

    class Assembler : ModuleAssembler {

        override fun assembleModule(fragment: Fragment) {
            val view = fragment as? ExamFragment ?: throw ViperModuleAssemblerException()

            val router = ExamRouter(view)
            val remoteDataManager = ExamRemoteDataManager()
            val interactor = ExamInteractor(remoteDataManager)
            val presenter = fragment.instantiateAndBindViewModel { ExamPresenter(view, router, interactor) }

            view.presenter = presenter
        }

    }

}
