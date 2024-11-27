package org.mapledpmlab.type.skill.attackskill.evan;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class DragonBreath extends AttackSkill {
    public DragonBreath() {
        this.setName("드래곤 브레스");
        this.setDamage(241.0);
        this.setAttackCount(5L);
        this.setDelay(30L);
        this.setDotDuration(3120L);
        this.setInterval(390L);
        this.setLimitAttackCount(8L);
        this.setCooldown(7.5);          // 드래곤 브레스-쿨타임 리듀스
        this.addFinalDamage(2.2);                   // 코어 강화
        this.addIgnoreDefenseList(20L);
        this.addFinalDamage(1.08);          // 오버로드 마나
        this.setApplyReuse(true);
    }
}
