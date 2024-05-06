package org.mapledpmlab.type.skill.attackskill.bowmaster;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class ArrawPlatter extends AttackSkill {
    public ArrawPlatter() {
        this.setName("애로우 플래터");
        this.setAttackCount(1L);
        this.setCooldown(60.0);
        this.setDelayByAttackSpeed(800L);
        this.setDamage(440.0);
        this.setDotDuration(60000L);
        this.setInterval(210L);
        this.setAddDamage(90L);         // 윈드 오브 프레이
        this.setFinalDamage(2.2);       // 코어강화
        this.addIgnoreDefenseList(20L);
        // 애로우 레인, 퀴버 카트리지, 모탈 블로우, 파이널 어택 등 미적용
    }
}
