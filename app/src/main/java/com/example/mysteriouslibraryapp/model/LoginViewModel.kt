package com.example.mysteriouslibraryapp.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {


    private val auth: FirebaseAuth = FirebaseAuth.getInstance()

    private val _email = MutableStateFlow("")
    val email: StateFlow<String> = _email

    private val _password = MutableStateFlow("")
    val password: StateFlow<String> = _password

    private val _loading = MutableStateFlow(false)
    val loading: StateFlow<Boolean> = _loading

    private val _snackbarMessage = MutableSharedFlow<String>()
    val snackbarMessage = _snackbarMessage.asSharedFlow()

    fun onEmailChange(newEmail: String) {
        _email.value = newEmail
    }

    fun onPasswordChange(newPassword: String) {
        _password.value = newPassword
    }

    fun loginOrRegister(isLogin: Boolean, onSuccess: () -> Unit) {
        _loading.value = true
        viewModelScope.launch {
            try {
                if (isLogin) {
                    auth.signInWithEmailAndPassword(_email.value, _password.value)
                        .addOnCompleteListener { task ->
                            if (task.isSuccessful) {
                                onSuccess()
                            } else {
                                _snackbarMessage.tryEmit(task.exception?.localizedMessage ?: "Inloggning misslyckades")
                            }
                            _loading.value = false
                        }
                } else {
                    auth.createUserWithEmailAndPassword(_email.value, _password.value)
                        .addOnCompleteListener { task ->
                            if (task.isSuccessful) {
                                onSuccess()
                            } else {
                                _snackbarMessage.tryEmit(task.exception?.localizedMessage ?: "Registrering misslyckades")
                            }
                            _loading.value = false
                        }
                }
            } catch (e: Exception) {
                _snackbarMessage.emit("Ett fel inträffade: ${e.message}")
                _loading.value = false
            }
        }
    }
}

