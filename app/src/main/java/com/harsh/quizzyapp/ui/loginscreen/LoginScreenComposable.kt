package com.harsh.quizzyapp.ui.loginscreen

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.harsh.quizzyapp.common.DataWrapper
import com.harsh.quizzyapp.R
import com.harsh.quizzyapp.ui.viewmodel.LoginViewModel

@Composable
fun LoginScreenComposable(
    viewModel: LoginViewModel,
    onLoginSuccess: () -> Unit
) {
    val schoolId by viewModel.schoolId.collectAsState()
    val studentId by viewModel.studentId.collectAsState()
    val loginState by viewModel.loginState.collectAsState()

    LaunchedEffect(loginState) {
        if (loginState is DataWrapper.Success) {
            onLoginSuccess()
        }
    }

    val isLoading = loginState is DataWrapper.Loading

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black).padding(8.dp)
    ) {
        FullScreenBackground(
            modifier = Modifier.matchParentSize()
        )

        LoginBottomSheet(
            schoolId = schoolId,
            studentId = studentId,
            isLoading = isLoading,
            errorMessage = (loginState as? DataWrapper.Error)?.throwable?.message,
            onSchoolIdChange = { viewModel.updateSchoolId(it) },
            onStudentIdChange = { viewModel.updateStudentId(it) },
            onLoginClick = { viewModel.login(onLoginSuccess) }
        )
    }
}

@Composable
private fun BoxScope.LoginBottomSheet(
    schoolId: String,
    studentId: String,
    isLoading: Boolean,
    errorMessage: String?,
    onSchoolIdChange: (String) -> Unit,
    onStudentIdChange: (String) -> Unit,
    onLoginClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .align(Alignment.BottomEnd)
            .fillMaxWidth()
            .clip(RoundedCornerShape(32.dp))
            .background(Color.White)
            .padding(20.dp),
        contentAlignment = Alignment.TopCenter
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                text = "Let's Get you Signed in",
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold,
                lineHeight = 20.sp,
                color = Color(27, 33, 36)
            )
            Spacer(Modifier.height(8.dp))

            OutlinedTextField(
                value = schoolId,
                onValueChange = onSchoolIdChange,
                placeholder = {
                    Text(
                        text = "Student Name",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Normal,
                        lineHeight = 20.sp,
                        color = Color(117, 117, 117)
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(16.dp)),
                shape = RoundedCornerShape(16.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedContainerColor = Color(0xFFF2F2F2),
                    focusedContainerColor = Color(0xFFF2F2F2),
                    unfocusedBorderColor = Color(0xFFE0E0E0),
                    focusedBorderColor = Color(0xFFE0E0E0)
                )
            )


            OutlinedTextField(
                value = studentId,
                onValueChange = onStudentIdChange,
                placeholder = {
                    Text(
                        text = "Student Name",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Normal,
                        lineHeight = 20.sp,
                        color = Color(117, 117, 117)
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(16.dp)),
                shape = RoundedCornerShape(16.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedContainerColor = Color(0xFFF2F2F2),
                    focusedContainerColor = Color(0xFFF2F2F2),
                    unfocusedBorderColor = Color(0xFFE0E0E0),
                    focusedBorderColor = Color(0xFFE0E0E0)
                )
            )

            Spacer(Modifier.height(16.dp))

            if (errorMessage != null) {
                Text(
                    text = errorMessage,
                    fontSize = 12.sp,
                    color = Color(0xFFE91E63),
                    modifier = Modifier.padding(bottom = 8.dp)
                )
            }

            Button(
                onClick = onLoginClick,
                enabled = !isLoading,
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(16.dp)),
                shape = RoundedCornerShape(16.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Black
                )
            ) {
                if (isLoading) {
                    CircularProgressIndicator(
                        modifier = Modifier.size(16.dp),
                        color = Color.White
                    )
                } else {
                    Text(
                        text = "Sign In",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.White,
                        modifier = Modifier.padding(vertical = 8.dp)
                    )
                }
            }

        }
    }
}


@Composable
private fun FullScreenBackground(
    modifier: Modifier = Modifier
){
    Box(
        modifier = modifier
            .fillMaxSize()
    ){
        FloatingImage(
            modifier = Modifier
                .border(1.dp,Color.Blue)
                .offset(10.dp, 20.dp)
        )
        FloatingImage(
            modifier = Modifier
                .offset(20.dp, 200.dp)
        )
        FloatingImage(
            modifier = Modifier
                .offset(300.dp, 220.dp)
        )
        FloatingImage(
            modifier = Modifier
                .border(1.dp,Color.Blue)
                .offset(120.dp, 20.dp)
        )
        FloatingImage(
            modifier = Modifier
                .offset(200.dp, 300.dp)
        )
        FloatingImage(
            modifier = Modifier
                .offset(30.dp, 400.dp)
        )




    }
}

@Composable
private fun FloatingImage(
    @DrawableRes image: Int = R.drawable.ic_accuracy_2,
    modifier: Modifier = Modifier.size(40.dp)
){

    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier.clip(CircleShape)
    ) {
        // Glow layer
        Box(
            modifier = Modifier
                .shadow(
                    elevation = 100.dp,
                    shape = CircleShape,
                    ambientColor = Color.White,
                    spotColor = Color.White
                )
                .background(Color.White.copy(alpha = 0.9f), CircleShape)
        )

        // Avatar image
        Image(
            painter = painterResource(id = image),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(0.3f)
        )
    }


}
