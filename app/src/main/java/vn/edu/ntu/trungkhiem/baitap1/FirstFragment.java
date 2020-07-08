package vn.edu.ntu.trungkhiem.baitap1;

import android.app.DatePickerDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Calendar;


public class FirstFragment extends Fragment {
    EditText edtHoten, edtNgaysinh, edtSdt, edtDiachi;
    RadioButton rbtTienmat, rbtNganhang,rbtVidientu;
    ImageView imgDate;
    Spinner spinner;
    Button btnDangky;
    String Hoten, Ngaysinh, Sodienthoai, Diachi, Phuongthuc, Dichvu;
    NavController navController;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_first, container, false);
        addView(view);
        addEvent();
        return view;
    }

    private void addEvent() {
        btnDangky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              Hoten = edtHoten.getText().toString();
              Ngaysinh = edtNgaysinh.getText().toString();
              Sodienthoai = edtNgaysinh.getText().toString();
              Diachi = edtDiachi.getText().toString();

                if(rbtTienmat.isChecked())
                {
                    Phuongthuc = "Tiền mặt";
                }

                if(rbtNganhang.isChecked())
                {
                    Phuongthuc = "Ngân hàng";
                }

                if(rbtVidientu.isChecked())
                {
                    Phuongthuc = "Ví điện tử";
                }

                Dichvu = spinner.getSelectedItem().toString();

                Bundle bundle = new Bundle();
                bundle.putString("Hoten",Hoten);
                bundle.putString("Ngaysinh",Ngaysinh);
                bundle.putString("Sodienthoai",Sodienthoai);
                bundle.putString("Diachi",Diachi);
                bundle.putString("Phuongthuc",Phuongthuc);
                bundle.putString("Dichvu",Dichvu);
                navController.navigate(R.id.action_firstFragment_to_secondFragment,bundle);

            }
        });

        imgDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar calendar = Calendar.getInstance();
                DatePickerDialog.OnDateSetListener listener = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int dayOfMonth, int month, int year) {
                        StringBuilder builder = new StringBuilder();
                        builder.append(dayOfMonth)
                                .append("-")
                                .append(++month)
                                .append("-")
                                .append(year);
                        edtNgaysinh.setText(builder.toString());
                    }
                };
                DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(),listener
                        ,calendar.get(Calendar.DAY_OF_MONTH),calendar.get(Calendar.MONTH),calendar.get(Calendar.YEAR));
                datePickerDialog.show();
            }
        });
    }

    private void addView(View view)
    {
        edtHoten = view.findViewById(R.id.edtHoten);
        edtNgaysinh = view.findViewById(R.id.edtNgaysinh);
        edtSdt = view.findViewById(R.id.edtSdt);
        edtDiachi = view.findViewById(R.id.edtDiachi);
        rbtTienmat = view.findViewById(R.id.rbtTienmat);
        rbtNganhang = view.findViewById(R.id.rbtNganhang);
        rbtVidientu = view.findViewById(R.id.rbtVidientu);
        imgDate = view.findViewById(R.id.imgDate);
        spinner = view.findViewById(R.id.spinner);
        btnDangky = view.findViewById(R.id.btDangky);
        navController = NavHostFragment.findNavController(FirstFragment.this);

        final String[] Dichvu = new  String[]{"Truyền hình cáp", "VTV4", "FPT"};
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(FirstFragment.this.getActivity(),
                R.layout.support_simple_spinner_dropdown_item,Dichvu);
        spinner.setAdapter(arrayAdapter);
    }
}
