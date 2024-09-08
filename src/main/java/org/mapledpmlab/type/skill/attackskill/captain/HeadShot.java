package org.mapledpmlab.type.skill.attackskill.captain;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class HeadShot extends AttackSkill {
    public HeadShot() {
        this.setName("헤드 샷");
        this.setDamage(999.0);
        this.setDelayByAttackSpeed(570L);
        this.setAttackCount(13L + 1);   // 헤드 샷-보너스 어택
        this.setCooldown(5.0);
        this.addIgnoreDefenseList(60L);
        this.setAddDamage(20L + 20);    // 헤드 샷-리인포스, 보스 킬러
        this.addFinalDamage(2.2);       // 코어강화
        this.addIgnoreDefenseList(20L);
        this.setApplyFinalAttack(true);
        this.setApplyReuse(true);
    }
}
