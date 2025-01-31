package org.mapledpmlab.type.skill.attackskill.luminous;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class TwilightNovaEclipse extends AttackSkill {
    public TwilightNovaEclipse() {
        this.setName("트와일라잇 노바(이클립스)");
        this.setDamage(1630.0);
        this.setDelayByAttackSpeed(780L);
        this.setAttackCount(7L * 2);
        this.setCooldown(15.0);
        this.addFinalDamage(0.75);
        this.setApplyReuse(true);
        //this.addFinalDamage(1.05);  // 어둠 마법 강화
        this.addFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
        this.addFinalDamage(1.08);  // 오버로드 마나
        this.getMultiAttackInfo().add(0L);
        this.getMultiAttackInfo().add(30L);
        this.getMultiAttackInfo().add(30L);
    }
}
