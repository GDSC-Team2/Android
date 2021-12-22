// Generated by view binder compiler. Do not edit!
package com.example.gonggu.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.gonggu.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityLoginBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final AppCompatButton emailFindBtn;

  @NonNull
  public final TextInputEditText emailSignEdit;

  @NonNull
  public final TextInputLayout emailSignLayout;

  @NonNull
  public final ImageView logoImg;

  @NonNull
  public final TextView logoTxt;

  @NonNull
  public final AppCompatButton pwFindBtn;

  @NonNull
  public final TextInputEditText pwSignEdit;

  @NonNull
  public final TextInputLayout pwSignLayout;

  private ActivityLoginBinding(@NonNull LinearLayout rootView,
      @NonNull AppCompatButton emailFindBtn, @NonNull TextInputEditText emailSignEdit,
      @NonNull TextInputLayout emailSignLayout, @NonNull ImageView logoImg,
      @NonNull TextView logoTxt, @NonNull AppCompatButton pwFindBtn,
      @NonNull TextInputEditText pwSignEdit, @NonNull TextInputLayout pwSignLayout) {
    this.rootView = rootView;
    this.emailFindBtn = emailFindBtn;
    this.emailSignEdit = emailSignEdit;
    this.emailSignLayout = emailSignLayout;
    this.logoImg = logoImg;
    this.logoTxt = logoTxt;
    this.pwFindBtn = pwFindBtn;
    this.pwSignEdit = pwSignEdit;
    this.pwSignLayout = pwSignLayout;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityLoginBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityLoginBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_login, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityLoginBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.email_find_btn;
      AppCompatButton emailFindBtn = ViewBindings.findChildViewById(rootView, id);
      if (emailFindBtn == null) {
        break missingId;
      }

      id = R.id.email_sign_edit;
      TextInputEditText emailSignEdit = ViewBindings.findChildViewById(rootView, id);
      if (emailSignEdit == null) {
        break missingId;
      }

      id = R.id.email_sign_layout;
      TextInputLayout emailSignLayout = ViewBindings.findChildViewById(rootView, id);
      if (emailSignLayout == null) {
        break missingId;
      }

      id = R.id.logo_img;
      ImageView logoImg = ViewBindings.findChildViewById(rootView, id);
      if (logoImg == null) {
        break missingId;
      }

      id = R.id.logo_txt;
      TextView logoTxt = ViewBindings.findChildViewById(rootView, id);
      if (logoTxt == null) {
        break missingId;
      }

      id = R.id.pw_find_btn;
      AppCompatButton pwFindBtn = ViewBindings.findChildViewById(rootView, id);
      if (pwFindBtn == null) {
        break missingId;
      }

      id = R.id.pw_sign_edit;
      TextInputEditText pwSignEdit = ViewBindings.findChildViewById(rootView, id);
      if (pwSignEdit == null) {
        break missingId;
      }

      id = R.id.pw_sign_layout;
      TextInputLayout pwSignLayout = ViewBindings.findChildViewById(rootView, id);
      if (pwSignLayout == null) {
        break missingId;
      }

      return new ActivityLoginBinding((LinearLayout) rootView, emailFindBtn, emailSignEdit,
          emailSignLayout, logoImg, logoTxt, pwFindBtn, pwSignEdit, pwSignLayout);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}