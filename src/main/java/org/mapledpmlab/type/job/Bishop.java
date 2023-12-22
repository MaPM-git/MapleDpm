package org.mapledpmlab.type.job;

import org.mapledpmlab.type.ability.BuffBossAbnormal;
import org.mapledpmlab.type.artifact.Artifact;
import org.mapledpmlab.type.etc.Common;
import org.mapledpmlab.type.etc.JobType;
import org.mapledpmlab.type.hyper.HyperCommon;
import org.mapledpmlab.type.link.HybridLogic;
import org.mapledpmlab.type.link.Noblesse;
import org.mapledpmlab.type.union.IntUnion;

import java.util.stream.Collectors;

public class Bishop extends Job {

    public Bishop() {
        // 기본
        super();
        this.setName("비숍");
        this.setConstant(1.2);          // 무기상수
        this.setMastery(1.95 / 2);      // 숙련도
        this.setJobType(JobType.ETC);

        // 무기
        this.addMainStat((long) (150 + 32 + 145));
        this.addSubStat((long) (150 + 145));
        this.addMagic((long) (406 + 250 + 72 + 276));
        this.setWeaponAttMagic((long) (406 + 250 + 72 + 276));
        this.addBossDamage((long) (30 + 10));
        this.addIgnoreDefenseList(20L);
        this.addBossDamage(70L);
        this.addMagicP(9L);
        this.addMagicP(21L);
        this.addMagicP(3L);

        // 보조
        this.addMainStat((long) (10 + 80 + 75));
        this.addSubStat(75L);
        this.addAtt(45L);
        this.addMagic((long) (1 + 45));
        this.addBossDamage(70L);
        this.addMagicP(9L);
        this.addMagicP(21L);

        // 2차
        this.addMainStat(20L);          // 매직 액셀레이션
        this.addMagic(10L);             // 스펠 마스터리
        this.addMainStat(40L);          // 하이 위즈덤

        // 3차
        this.addCriticalP(30.0);        // 매직 크리티컬
        this.addCriticalDamage(13.0);
        this.addCriticalP(40.0);        // 홀리 포커스

        // 4차
        this.addFinalDamage(1.06);      // 블레싱 하모니
        this.addAtt(51L);               // 어드밴스드 블레스
        this.addMagic(51L);
        this.addBossDamage(10L);
        this.addIgnoreDefenseList(21L); // 아케인 에임
        this.addMagic(33L);             // 마스터 매직
        this.addPlusBuffDuration(55L);

        // 하이퍼
        this.addMagic(50L);             // 벤전스 오브 엔젤
        this.addFinalDamage(1.3);
        this.addIgnoreDefenseList(20L);
        this.addProperty(10L);

        // 5차
        this.addMainStat(30L);          // 언스태이블 메모라이즈

        // 6차
        this.addMainStat(90L);          // 프레이 강화

        this.setAbility(new BuffBossAbnormal());
        this.setArtifact(new Artifact());
        this.getLinkList().add(new HybridLogic());
        this.getLinkList().add(new Noblesse());
        this.setUnion(new IntUnion());
        this.addPerXMainStat(20L);

        this.addObject(this.getAbility());
        this.addObject(this.getArtifact());
        this.addObject(this.getLinkList().stream().map(s -> (Common) s).collect(Collectors.toList()));
        this.addObject(this.getUnion());
        this.setHyper(new HyperCommon(this.getLevel(), this.getCriticalP()));
        this.addObject(this.getHyper());
    }

    @Override
    public void Doping() {
        super.Doping();
        addFinalDamage(1.01);      // 브레싱 앙상블
        addFinalDamage(1.1);            // 엔젤레이 5중첩
        addDamage(40L);                 // 아케인 에임
        addFinalDamage(1.08);           // 오버로드 마나
        addIgnoreDefenseList(44L);      // 엔젤릭 터치 상시 유지
    }

    public Long getStatDamage() {
        return (long) Math.floor(
                (this.getFinalMainStat() * 4 + getFinalSubstat()) * 0.01
                        * Math.floor(this.getMagic() * (1 + this.getMagicP() * 0.01))
                        * this.getConstant()
                        * (1 + this.getDamage() * 0.01)
                        * this.getFinalDamage()
        );
    }
}
