package com.aaa.Imple;

import com.aaa.Entity.Doormirror;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface DoormirrorImple {

    List<Doormirror> showDoormirror();

    Integer AddDoormirror(Doormirror doormirror);

}
