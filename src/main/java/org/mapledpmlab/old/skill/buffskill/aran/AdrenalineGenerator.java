package org.mapledpmlab.old.skill.buffskill.aran;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class AdrenalineGenerator extends BuffSkill {
    public AdrenalineGenerator() {
        this.setName("아드레날린 제너레이터");
        this.setCooldown(180.0);
        this.setRelatedSkill(new AdrenalineBoost());
    }
}
