package org.mapledpmlab.type.skill.attackskill.kain;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;
import org.mapledpmlab.type.skill.buffskill.kain.DeathBlessingContributionBuff;

public class DeathBlessing extends AttackSkill {
    public DeathBlessing() {
        this.setName("데스 블레싱(축복 실현)");
        this.setDamage(140.0 + 168);
        this.setAttackCount(10L);
        this.addFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
        this.setRelatedSkill(new DeathBlessingContributionBuff());
    }
}
