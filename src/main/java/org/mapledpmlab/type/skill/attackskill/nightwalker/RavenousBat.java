package org.mapledpmlab.type.skill.attackskill.nightwalker;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.attackskill.AttackSkill;

@Getter
@Setter
public class RavenousBat extends AttackSkill implements DarkAttack {

    boolean isReady = true;

    public RavenousBat() {
        this.setName("래버너스 배트");
        this.setFinalAttack(true);
        this.setAttackCount(2L);
        this.setDamage(980.0);
        this.addFinalDamage(2.2);       // 코어강화
        this.addIgnoreDefenseList(20L);
    }
}
