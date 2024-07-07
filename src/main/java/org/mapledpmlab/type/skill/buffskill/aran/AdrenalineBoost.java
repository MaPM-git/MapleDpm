package org.mapledpmlab.type.skill.buffskill.aran;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.attackskill.aran.IceWave;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class AdrenalineBoost extends BuffSkill {
    public AdrenalineBoost() {
        this.setName("아드레날린 부스트");
        this.setDuration(15L + 5);      // 아드레날린 부스트-퍼시스트
        this.setRelatedSkill(new IceWave());
    }
}
