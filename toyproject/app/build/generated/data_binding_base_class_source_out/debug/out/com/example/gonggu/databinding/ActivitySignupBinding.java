// Generated by view binder compiler. Do not edit!
package com.example.gonggu.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

public final class ActivitySignupBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final AppCompatButton back2loginBtn;

  @NonNull
  public final AppCompatButton emailAuthBtn;

  @NonNull
  public final TextInputEditText emailSignupEdit;

  @NonNull
  public final TextInputLayout emailSignupLayout;

  @NonNull
  public final TextInputEditText nameSignupEdit;

  @NonNull
  public final TextInputLayout nameSignupLayout;

  @NonNull
  public final TextInputEditText pwCheckEdit;

  @NonNull
  public final TextInputLayout pwCheckLayout;

  @NonNull
  public final TextInputEditText pwSignupEdit;

  @NonNull
  public final TextInputLayout pwSignupLayout;

  @NonNull
  public final AppCompatButton signupCompBtn;

  @NonNull
  public final TextView text1;

  private ActivitySignupBinding(@NonNull LinearLayout rootView,
      @NonNull AppCompatButton back2loginBtn, @NonNull AppCompatButton emailAuthBtn,
      @NonNull TextInputEditText emailSignupEdit, @NonNull TextInputLayout emailSignupLayout,
      @NonNull TextInputEditText nameSignupEdit, @NonNull TextInputLayout nameSignupLayout,
      @NonNull TextInputEditText pwCheckEdit, @NonNull TextInputLayout pwCheckLayout,
      @NonNull TextInputEditText pwSignupEdit, @NonNull TextInputLayout pwSignupLayout,
      @NonNull AppCompatButton signupCompBtn, @NonNull TextView text1) {
    this.rootView = rootView;
    this.back2loginBtn = back2loginBtn;
    this.emailAuthBtn = emailAuthBtn;
    this.emailSignupEdit = emailSignupEdit;
    this.emailSignupLayout = emailSignupLayout;
    this.nameSignupEdit = nameSignupEdit;
    this.nameSignupLayout = nameSignupLayout;
    this.pwCheckEdit = pwCheckEdit;
    this.pwCheckLayout = pwCheckLayout;
    this.pwSignupEdit = pwSignupEdit;
    this.pwSignupLayout = pwSignupLayout;
    this.signupCompBtn = signupCompBtn;
    this.text1 = text1;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivitySignupBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivitySignupBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_signup, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivitySignupBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.back2login_btn;
      AppCompatButton back2loginBtn = ViewBindings.findChildViewById(rootView, id);
      if (back2loginBtn == null) {
        break missingId;
      }

      id = R.id.email_auth_btn;
      AppCompatButton emailAuthBtn = ViewBindings.findChildViewById(rootView, id);
      if (emailAuthBtn == null) {
        break missingId;
      }

      id = R.id.email_signup_edit;
      TextInputEditText emailSignupEdit = ViewBindings.findChildViewById(rootView, id);
      if (emailSignupEdit == null) {
        break missingId;
      }

      id = R.id.email_signup_layout;
      TextInputLayout emailSignupLayout = ViewBindings.findChildViewById(rootView, id);
      if (emailSignupLayout == null) {
        break missingId;
      }

      id = R.id.name_signup_edit;
      TextInputEditText nameSignupEdit = ViewBindings.findChildViewById(rootView, id);
      if (nameSignupEdit == null) {
        break missingId;
      }

      id = R.id.name_signup_layout;
      TextInputLayout nameSignupLayout = ViewBindings.findChildViewById(rootView, id);
      if (nameSignupLayout == null) {
        break missingId;
      }

      id = R.id.pw_check_edit;
      TextInputEditText pwCheckEdit = ViewBindings.findChildViewById(rootView, id);
      if (pwCheckEdit == null) {
        break missingId;
      }

      id = R.id.pw_check_layout;
      TextInputLayout pwCheckLayout = ViewBindings.findChildViewById(rootView, id);
      if (pwCheckLayout == null) {
        break missingId;
      }

      id = R.id.pw_signup_edit;
      TextInputEditText pwSignupEdit = ViewBindings.findChildViewById(rootView, id);
      if (pwSignupEdit == null) {
        break missingId;
      }

      id = R.id.pw_signup_layout;
      TextInputLayout pwSignupLayout = ViewBindings.findChildViewById(rootView, id);
      if (pwSignupLayout == null) {
        break missingId;
      }

      id = R.id.signup_comp_btn;
      AppCompatButton signupCompBtn = ViewBindings.findChildViewById(rootView, id);
      if (signupCompBtn == null) {
        break missingId;
      }

      id = R.id.text1;
      TextView text1 = ViewBindings.findChildViewById(rootView, id);
      if (text1 == null) {
        break missingId;
      }

      return new ActivitySignupBinding((LinearLayout) rootView, back2loginBtn, emailAuthBtn,
          emailSignupEdit, emailSignupLayout, nameSignupEdit, nameSignupLayout, pwCheckEdit,
          pwCheckLayout, pwSignupEdit, pwSignupLayout, signupCompBtn, text1);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
