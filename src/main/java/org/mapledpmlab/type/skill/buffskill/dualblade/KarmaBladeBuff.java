package org.mapledpmlab.type.skill.buffskill.dualblade;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.attackskill.dualblade.FinalCut;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class KarmaBladeBuff extends BuffSkill {
    public KarmaBladeBuff() {
        this.setName("카르마 블레이드");
        this.setDuration(20L);
    }
}
