package com.example.qadam10;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.qadam10.Models.User;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.rengwuxian.materialedittext.MaterialEditText;

public class MainActivity extends AppCompatActivity {

    Button SignButton;
    Button RegisterButton;
    FirebaseAuth auth;
    FirebaseDatabase db;
    DatabaseReference users;
    ConstraintLayout root;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         SignButton =  findViewById(R.id.SignBtn);
        RegisterButton = findViewById(R.id.RegisterBtn);
        root = findViewById(R.id.root_element);
       auth = FirebaseAuth.getInstance();
       db = FirebaseDatabase.getInstance();
       users = db.getReference("Users");



       SignButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               showSignWindow();
           }
       });


         RegisterButton.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 showRegisterWindow();
             }
         });



    }

    private void showSignWindow(){
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle("Войти");
        dialog.setMessage("Введите данные для входа");

        LayoutInflater inflater = LayoutInflater.from(this);
        View register_window = inflater.inflate(R.layout.activity_sign,null);
        dialog.setView(register_window);


        final MaterialEditText email = register_window.findViewById(R.id.signEmail);
        final MaterialEditText password = register_window.findViewById(R.id.signPassword);

        dialog.setNegativeButton("Отменить", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });

        dialog.setPositiveButton("Войти", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if(TextUtils.isEmpty(email.getText().toString())){
                    Snackbar.make(root,"Введите вашу почту",Snackbar.LENGTH_SHORT).show();
                    return;
                }

                if(password.getText().toString().length()<5){
                    Snackbar.make(root,"Введите пароль,более 5 символов",Snackbar.LENGTH_SHORT).show();
                    return;
                }
               auth.signInWithEmailAndPassword(email.getText().toString(),password.getText().toString())
                       .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                           @Override
                           public void onSuccess(AuthResult authResult) {
                               startActivity(new Intent(MainActivity.this,LoginActivity.class));
                           }
                       }).addOnFailureListener(new OnFailureListener() {
                   @Override
                   public void onFailure(@NonNull Exception e) {
                       Snackbar.make(root,"Ошибка авторизации." + e.getMessage(),Snackbar.LENGTH_SHORT).show();
                   }
               });
            }

        });

        dialog.show();
    }


    private void showRegisterWindow() {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle("Зарегистрироваться");
        dialog.setMessage("Введите все данные для регистрации");

        LayoutInflater inflater = LayoutInflater.from(this);
        View register_window = inflater.inflate(R.layout.activity_register,null);
        dialog.setView(register_window);

        final MaterialEditText name = register_window.findViewById(R.id.editTextTextPersonName);
        final MaterialEditText email = register_window.findViewById(R.id.editTextTextEmailAddress2);
        final MaterialEditText password = register_window.findViewById(R.id.editTextTextPassword2);

        dialog.setNegativeButton("Отменить", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });

        dialog.setPositiveButton("Добавить", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if(TextUtils.isEmpty(email.getText().toString())){
                    Snackbar.make(root,"Введите вашу почту",Snackbar.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(name.getText().toString())){
                    Snackbar.make(root,"Введите ваше имя",Snackbar.LENGTH_SHORT).show();
                    return;
                }
                if(password.getText().toString().length()<5){
                    Snackbar.make(root,"Введите пароль,более 5 символов",Snackbar.LENGTH_SHORT).show();
                    return;
                }
                //Регистрация
                auth.createUserWithEmailAndPassword(email.getText().toString(),password.getText().toString())
                        .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                            @Override
                            public void onSuccess(AuthResult authResult) {
                                User user = new User();
                                user.setEmail(email.getText().toString());
                                user.setPassword(password.getText().toString());
                                user.setName(name.getText().toString());

                                users.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).setValue(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void aVoid) {
                                        Snackbar.make(root,"Пользователь добавлен",Snackbar.LENGTH_SHORT).show();
                                    }
                                }).addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Snackbar.make(root,"Ошибка регистрации" + e.getMessage(),Snackbar.LENGTH_SHORT).show();
                                    }
                                });
                            }
                        });
            }
        });

        dialog.show();
    }


}