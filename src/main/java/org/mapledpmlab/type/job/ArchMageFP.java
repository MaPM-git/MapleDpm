package org.mapledpmlab.type.job;

import org.mapledpmlab.type.ability.BuffBossAbnormal;
import org.mapledpmlab.type.artifact.ArtifactNormal;
import org.mapledpmlab.type.etc.Common;
import org.mapledpmlab.type.etc.JobType;
import org.mapledpmlab.type.hyper.HyperCommon;
import org.mapledpmlab.type.link.*;
import org.mapledpmlab.type.union.IntUnion;

import java.util.stream.Collectors;

public class ArchMageFP extends Job {

    public ArchMageFP() {
        // 기본
        super();
        this.setName("아크메이지(불,독)");
        this.setConstant(1.2);          // 무기상수
        this.setMastery(1.96 / 2);      // 숙련도
        this.setJobType(JobType.COOLDOWN_REDUCTION_MAX);

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
        this.addMagic(30L);             // 메디테이션
        this.addMainStat(20L);          // 매직 액셀레이션
        this.addMagic(10L);             // 스펠 마스터리
        this.addCriticalP(5.0);
        this.addMainStat(40L);          // 하이 위즈덤

        // 3차
        this.addProperty(10L);          // 엘리멘탈 리셋
        this.addFinalDamage(1.4);
        this.addCriticalP(30.0);        // 매직 크리티컬
        this.addCriticalDamage(13.0);

        // 4차
        this.addIgnoreDefenseList(21L); // 아케인 에임
        this.addMagic(33L);             // 마스터 매직
        this.addPlusBuffDuration(55L);

        // 5차
        this.addMainStat(30L);          // 언스태이블 메모라이즈

        // 환산 보정
        this.addMainStatP(66L);
        this.addMainStat(10L);
        this.addSubStat(15L);

        this.setAbility(new BuffBossAbnormal());
        this.setArtifact(new ArtifactNormal());
        this.getLinkList().add(new PhantomInstinct());
        this.getLinkList().add(new Noblesse());
        this.setUnion(new IntUnion());

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
        addDamage(50L);                 // 앨리먼트 앰플리케이션
        addFinalDamage(1.2);            // 익스트림 매직
        addDamage(40L);                 // 아케인 에임
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
