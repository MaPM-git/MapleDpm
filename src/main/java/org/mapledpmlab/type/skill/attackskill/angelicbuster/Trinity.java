package org.mapledpmlab.type.skill.attackskill.angelicbuster;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class Trinity extends AttackSkill {
    public Trinity() {
        this.setName("트리니티");
        this.setDamage(1020.0 + 146);
        this.setDelayByAttackSpeed(780L);
        this.setAttackCount(6L + 1);
        this.addFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
        this.setAddDamage(30L + 20);    // 트리니티-리인포스
        this.addIgnoreDefenseList(30L);
    }
}
