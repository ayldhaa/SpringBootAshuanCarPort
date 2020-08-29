package com.aaa.Dao;

import com.aaa.Entity.Doormirror;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoormirrorDao {

    List<Doormirror> showDoormirror();

    Integer AddDoormirror(Doormirror doormirror);

}
