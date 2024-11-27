package org.mapledpmlab.type.skill.buffskill.angelicbuster;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class SoulContractAB extends BuffSkill {
    public SoulContractAB() {
        this.setName("소울 컨트랙트");
        this.setBuffDamage(90L);
        this.setCooldown(60.0);
        this.setDuration(10L);
        this.setApplyPlusBuffDuration(true);
        this.setDelay(30L);
    }
}
