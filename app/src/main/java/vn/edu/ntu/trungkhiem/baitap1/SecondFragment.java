package vn.edu.ntu.trungkhiem.baitap1;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class SecondFragment extends Fragment {
    TextView txtHoten, txtNgaysinh, txtDichvu, txtSdt, txtDiachi, txtPhuongthuc;
    Button btnThoat;
    String Hoten, Ngaysinh, Sodienthoai, Dichvu, DiaChi, Phuongthuc;
    NavController navController;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_second, container, false);
        getData();
        addView(view);
        addEvent();

        return view;
    }
    private void addEvent() {
        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             navController.navigate(R.id.action_secondFragment_to_firstFragment);
            }
        });
    }

    private void addView(View view) {
        txtHoten = view.findViewById(R.id.txtHoten);
        txtNgaysinh = view.findViewById(R.id.txtNgaysinh);
        txtDichvu = view.findViewById(R.id.txtDichvu);
        txtSdt = view.findViewById(R.id.txtSdt);
        txtPhuongthuc = view.findViewById(R.id.txtPhuongthuc);
        txtDiachi = view.findViewById(R.id.txtDiachi);
        btnThoat = view.findViewById(R.id.btnThoat);

        navController = NavHostFragment.findNavController(SecondFragment.this);

        txtHoten.setText(Hoten);
        txtNgaysinh.setText(Ngaysinh);
        txtDichvu.setText(Dichvu);
        txtPhuongthuc.setText(Phuongthuc);
        txtSdt.setText(Sodienthoai);
        txtDiachi.setText(DiaChi);

    }
    private void getData() {
        Bundle bundle = getArguments();
        Hoten = bundle.getString("HoTen");
        Ngaysinh = bundle.getString("Ngaysinh");
        Dichvu = bundle.getString("Dichvu");
        Sodienthoai = bundle.getString("Sodienthoai");
        Phuongthuc = bundle.getString("Phuongthuc");
        DiaChi = bundle.getString("Diachi");

    }

}
