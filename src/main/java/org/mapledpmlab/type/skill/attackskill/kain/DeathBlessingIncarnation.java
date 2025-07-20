package org.mapledpmlab.type.skill.attackskill.kain;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;
import org.mapledpmlab.type.skill.buffskill.kain.DeathBlessingContributionBuff;

public class DeathBlessingIncarnation extends AttackSkill {
    public DeathBlessingIncarnation() {
        this.setName("데스 블레싱(인카네이션)");
        this.setDamage(620.0);
        this.setAttackCount(13L);
        this.addFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
        this.setRelatedSkill(new DeathBlessingContributionBuff());
    }
}
