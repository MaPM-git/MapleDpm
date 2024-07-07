package org.mapledpmlab.old.skill.buffskill.aran;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class AdrenalineBoost extends BuffSkill {
    public AdrenalineBoost() {
        this.setName("아드레날린 부스트");
        this.setDuration(15L + 5);
    }
}
