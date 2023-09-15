@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class)

package com.example.loginflow.components

import android.graphics.Paint.Style
import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material.icons.sharp.Favorite
import androidx.compose.material.icons.sharp.FavoriteBorder
import androidx.compose.material.icons.sharp.Visibility
import androidx.compose.material.icons.sharp.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.loginflow.navigation.Screen
import com.example.loginflow.ui.theme.Purple40
import com.example.loginflow.ui.theme.Purple80
import com.example.loginflow.ui.theme.TextColor

@Composable
fun NormalTextComponents(value: String) {
    Text(
        text = value, modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 40.dp), style = TextStyle(
            fontSize = 24.sp, fontWeight = FontWeight.Normal, fontStyle = FontStyle.Normal
        ), color = TextColor, textAlign = TextAlign.Center
    )

}

@Composable
fun HeadingTextComponents(value: String) {
    Text(
        text = value, modifier = Modifier
            .fillMaxWidth()
            .heightIn(), style = TextStyle(
            fontSize = 30.sp, fontWeight = FontWeight.Bold, fontStyle = FontStyle.Normal
        ), color = TextColor, textAlign = TextAlign.Center
    )
}

@Composable
fun MyTextField(labelValue: String, imageVector: ImageVector) {

    val textValue = remember {
        mutableStateOf("")
    }
    OutlinedTextField(modifier = Modifier.fillMaxWidth(),
        label = { Text(text = labelValue) },
        value = textValue.value,
        keyboardOptions = KeyboardOptions.Default,
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Purple80, focusedLabelColor = Purple40, cursorColor = Purple80
        ),
        onValueChange = { textValue.value = it },
        leadingIcon = {
            Icon(imageVector, contentDescription = null)
        })
}

@Composable
fun PasswordTextField(labelValue: String) {

    val password = remember {
        mutableStateOf("")
    }

    val passwordVisible = remember {
        mutableStateOf(false)
    }

    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        label = { Text(text = labelValue) },
        value = password.value,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Purple80, focusedLabelColor = Purple40, cursorColor = Purple80
        ),
        onValueChange = { password.value = it },
        leadingIcon = {
            Icon(imageVector = Icons.Filled.Favorite, contentDescription = null)
        },
        trailingIcon = {
            val iconImage = if (passwordVisible.value) {
                Icons.Filled.Visibility
            } else {
                Icons.Sharp.VisibilityOff
            }
            IconButton(onClick = { passwordVisible.value = !passwordVisible.value }) {
                Icon(imageVector = iconImage, contentDescription = null)
            }
        },
        visualTransformation = if (passwordVisible.value) {
            VisualTransformation.None
        } else {
            PasswordVisualTransformation()
        }
    )
}

@Composable
fun CheckboxComponent() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(56.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        val checkedState = remember { mutableStateOf(false) }

        Checkbox(checked = checkedState.value, onCheckedChange = {
            checkedState.value = !checkedState.value
        })
        ClickableTextComponent()
    }
}

@Composable
fun ClickableTextComponent() {
    val annotatedString = buildAnnotatedString {
        append("By continuing you accept our ")
        withStyle(style = SpanStyle(color = Purple40)) {
            pushStringAnnotation(tag = "Privacy Policy", annotation = "Privacy Policy")
            append("Privacy Policy")
        }
        append(" and ")
        withStyle(style = SpanStyle(color = Purple40)) {
            pushStringAnnotation(tag = "Terms of Use", annotation = "Terms of Use")
            append("Terms of Use")
        }

    }

    ClickableText(text = annotatedString, onClick = { offset ->
        annotatedString.getStringAnnotations(offset, offset).firstOrNull()?.also { span ->
            Log.d("Valid Click", "${span.item}")
            if (span.item == "Privacy Policy" || span.item == "Terms of Use") {

            }
        }
    })
}

@Composable
fun ButtonComponent(label: String,navController: NavController) {
    Button(
        onClick = {
            navController.popBackStack()
                  }, modifier = Modifier
            .fillMaxWidth()
            .heightIn(48.dp)
    ) {
        Text(
            text = label, style = TextStyle(
                fontWeight = FontWeight.Bold, fontSize = 18.sp
            )
        )
    }
}

@Composable
fun DividerComponent() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f), color = Color.Black, thickness = 1.dp
        )
        Text(
            text = "or", style = TextStyle(fontSize = 16.sp),
            modifier = Modifier.padding(start = 8.dp, end = 8.dp)
        )
        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f), color = Color.Black, thickness = 1.dp
        )
    }
}

@Composable
fun ClickableLoginTextComponent(navController: NavController) {
    val annotatedString = buildAnnotatedString {
        append("Already have an Account? ")
        withStyle(style = SpanStyle(color = Purple40)) {
            pushStringAnnotation(tag = "login", annotation = "login")
            append("Login")
        }
    }
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        ClickableText(text = annotatedString, onClick = { offset ->
            annotatedString.getStringAnnotations(offset, offset).firstOrNull()?.also { span ->
                Log.d("Valid Click", "${span.item}")
                if (span.item == "login") {
                    navController.navigate(Screen.LoginScreen.route)
                }
            }
        })
    }

}

@Composable
fun ClickableSignupTextComponent(navController: NavController) {
    val annotatedString = buildAnnotatedString {
        append("Don't have an Account? ")
        withStyle(style = SpanStyle(color = Purple40)) {
            pushStringAnnotation(tag = "signup", annotation = "signup")
            append("Sign Up")
        }
    }
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        ClickableText(text = annotatedString, onClick = { offset ->
            annotatedString.getStringAnnotations(offset, offset).firstOrNull()?.also { span ->
                Log.d("Valid Click", "${span.item}")
                if (span.item == "signup") {
                    navController.navigate(Screen.SignUpScreen.route)
                }
            }
        })
    }

}