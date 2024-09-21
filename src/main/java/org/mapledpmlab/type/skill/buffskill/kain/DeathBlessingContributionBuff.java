package org.mapledpmlab.type.skill.buffskill.kain;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class DeathBlessingContributionBuff extends BuffSkill {
    public DeathBlessingContributionBuff() {
        this.setName("데스 블레싱(공로 버프)");
        this.setDuration(5L);
        this.setApplyServerLag(true);
    }
}
