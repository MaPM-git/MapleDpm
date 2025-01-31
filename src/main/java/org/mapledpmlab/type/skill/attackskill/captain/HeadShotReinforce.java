package org.mapledpmlab.type.skill.attackskill.captain;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class HeadShotReinforce extends AttackSkill {
    public HeadShotReinforce() {
        this.setName("데스 헤일");
        this.setDamage(1266.0);
        this.setDelayByAttackSpeed(570L);
        this.setAttackCount(13L + 1);   // 헤드 샷-보너스 어택
        this.setCooldown(5.0);
        this.addIgnoreDefenseList(60L);
        this.setAddDamage(20L + 20);    // 헤드 샷-리인포스, 보스 킬러
        this.addFinalDamage(2.2);       // 코어강화
        this.addIgnoreDefenseList(20L);
        this.setApplyFinalAttack(true);
        this.setApplyReuse(true);
        this.getMultiAttackInfo().add(0L);
        this.getMultiAttackInfo().add(180L);
    }
}
